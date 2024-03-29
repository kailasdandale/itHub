package com.cog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cog.emailservice.EmailService;
import com.cog.exception.ReaderNotFound;
import com.cog.model.Books;
import com.cog.model.Reader;
import com.cog.service.ReaderService;

@RestController
@RequestMapping("api/books/v1/reader")
@CrossOrigin("*")
public class ReaderController {

	@Autowired
	private EmailService eservice;

	@Autowired
	private RestTemplate rt;
	@Autowired
	private ReaderService rservice;

	// reader can search book//
	@GetMapping("/search/{query}")
	public ResponseEntity<List<Books>> searchBook(@PathVariable("query") String query) {
		String url = "http://DIGITAL-BOOK/api/books/v1/Books/search?query=" + query + "";

		return new ResponseEntity<List<Books>>(rt.getForObject(url, List.class), HttpStatus.OK);
	}

	// reader can buy book//
	@PostMapping("/subscribe") // click on Book save BookId with Reader
	public ResponseEntity<Reader> buyBook(@RequestBody Reader r) {

		String email = r.getEmail();
		System.out.println(email);
	//	eservice.sendEmailreader(email);
		return new ResponseEntity<Reader>(rservice.save(r), HttpStatus.CREATED);
	}

	// reader can read
	@GetMapping("/{readerId}")
	public ResponseEntity<Reader> getReader(@PathVariable int readerId) throws ReaderNotFound {
		return new ResponseEntity<Reader>(rservice.findByReaderId(readerId), HttpStatus.OK);
	}

	// find subscribe books//
	@GetMapping("/findsubscribeBook/{email}")
	public List<Books> getReaderWithBook(@PathVariable String email) {
		System.out.println("in reader controller");
		return rservice.getReaderWithBook(email);

	}

	// only view unblock books
	@GetMapping("/findAll")
	public List<Books> findAll() {
		System.out.println("in reader controller");
		String url = "http://DIGITAL-BOOK/api/books/v1/Books/getAllBooks";
		return rt.getForObject(url, List.class);
	}

}
