package com.cog.secirityservice;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cog.model.Author;
import com.cog.repository.AuthorRepository;

@Service
public class JwtUserDetailsService implements UserDetailsService {
	@Autowired
	private AuthorRepository repo;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
// find user from database where user = :username
// userRepo.findByUsername(username);// username, password, roles

	Author a=repo.findByUsername(username);

	//raj
	if(a.getUsername().equals(username)) {
		Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_" + "AUTHOR"));
        authorities.add(new SimpleGrantedAuthority("ROLE_" + "AUTHOR"));
        authorities.add(new SimpleGrantedAuthority("ROLE_" + "Writer"));

        // raj@123
		return new User(username,
				 "$2a$12$qLtLATUw.udvJWsg1xzN7udkZL1gK7Jf6HqxuBppUIw54A3/y33oS", authorities);
	
	}
	
		else {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
	}
}
