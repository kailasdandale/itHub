package com.cog.secirityservice;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cog.model.Admin;
import com.cog.repository.AdminRepo;

@Service
public class JwtUserDetailsService implements UserDetailsService {
	@Autowired
	private AdminRepo repo;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

	Admin a=repo.findByUsername(username);

	//raj
	if(a.getUsername().equals(username)) {
		Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_" + "ADMIN"));
    //    authorities.add(new SimpleGrantedAuthority("ROLE_" + "AUTHOR"));
    //    authorities.add(new SimpleGrantedAuthority("ROLE_" + "Writer"));

        // raj@123
		return new User(username,
				 a.getPassword(), authorities);
	}
		else {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
	}
}
