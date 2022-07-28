package com.cog.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cog.exceptions.AuthorNotFoundException;
import com.cog.model.Author;
import com.cog.repository.AuthorRepository;

@Service
public class AuthorService {

	@Autowired
	private AuthorRepository arepo;

	public Author createAccount(Author author) {
		
		return arepo.save(author);
	}

	public Author login(String username, String password) throws AuthorNotFoundException {
		Author a=new Author();
		
		if(a.getUsername().equals(username) && a.getPassword().equals(password)) {
			System.out.println("in service"+username);
			return arepo.findByUsernameAndPassword(username,password);
		}
		 throw new AuthorNotFoundException("Invalid Username or Password");
	}
}
