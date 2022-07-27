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

	public Author login(String authorName, String password) throws AuthorNotFoundException {
		Author a=new Author();
		if(a.getAuthorName()==authorName && a.getpassword()==password) {
			return arepo.findByAuthorNameAndPassword(authorName,password);
		}
		 throw new AuthorNotFoundException("Invalid User");
	}
}
