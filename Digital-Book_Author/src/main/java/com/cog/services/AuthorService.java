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

	public Author login(String uname, String pass) throws AuthorNotFoundException {
		Author a = new Author();

		System.out.println("in servece"+uname+":"+pass);
		if(a.getUsername()==uname && a.getPassword()==pass)
		{
			return arepo.findByUsernameAndPassword(uname,pass);
		}
		throw new AuthorNotFoundException("Invalid Username or Password");
	}
}
