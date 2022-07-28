package com.cog.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cog.model.Books;
import com.cog.repository.BookRepo;

@Service
public class BookService {

	@Autowired
	private BookRepo brepo;

	public Books addBook(Books b) {

		return brepo.save(b);
	}

	public List<Books> findAll() {
		List<Books> l = brepo.findAll();
		List<Books> list = l.stream().filter(e -> e.getActive().equals("unblock")).collect(Collectors.toList());
		return list;
	}

	public Books findByBookId(int bookId) {

		return brepo.findByBookId(bookId);
	}

	public List<Books> searchBooks(String query) {

		return brepo.search(query);
	}

	public Books update(int bookId, Books book) {
		Books b=brepo.findByBookId(bookId);
		
		if(book.getBookName()!=null) {
			b.setBookName(book.getBookName());
		}
		if(book.getBookPrice()!=0) {
			b.setBookPrice(book.getBookPrice());
		}
		if(book.getAuthorName()!=null) {
			b.setAuthorName(book.getAuthorName());
		}
		if(book.getCategory()!=null) {
			b.setCategory(book.getCategory());
		}
		if(book.getPublishar()!=null) {
			b.setPublishar(book.getPublishar());
		}
		if(book.getActive()!=null) {
			b.setActive(book.getActive());
		}
		
	//	book.setBookId(bookId);
		
		 brepo.save(b);
		 return b;
	}

	public Books blockUnblock(int bookId, Books book) {
		book.setBookId(bookId);

		return brepo.save(book);
	}

//	public List<Books> search(String query) {
//		// TODO Auto-generated method stub
//		return brepo.search(query);
//	}

}
