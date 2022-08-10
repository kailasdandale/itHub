package com.cog.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cog.exceptions.AuthorNotFoundException;
import com.cog.model.Author;
import com.cog.services.AuthorService;
import com.cog.vo.Books;

@RestController
@RequestMapping("api/books/v1/author")
@CrossOrigin("*")
public class AuthorController {

	@Autowired
	private AuthorService aservice;
	@Autowired
	private RestTemplate rt;
	
	
	@GetMapping("/get")
	public String getWelcomeMassage() {
		return "welcome";
	}
	
	//Author can create Account//
	@PostMapping("/sinup")
	public  ResponseEntity<Author>createAccount(@RequestBody Author author){
		return new ResponseEntity<Author>
		(aservice.createAccount(author),HttpStatus.CREATED);
	}
	//Author can login//
	@GetMapping("/login/{username}/{password}")
	public ResponseEntity<Author>login(@PathVariable("username")String uname,
			@PathVariable("password")
	String pass) throws AuthorNotFoundException{
		return new ResponseEntity<Author>(aservice.login(uname, pass),HttpStatus.ACCEPTED);
	}
	
	//add new Book//
	@PostMapping("/addBooks")
	public ResponseEntity<Books>addBook(@RequestBody Books book){
		String url="http://DIGITAL-BOOK/api/books/v1/Books/addBook";
		return new ResponseEntity<Books>
		(rt.postForObject(url, book, Books.class),HttpStatus.CREATED);
	}
	
	
	//Author can Search Books//
	@GetMapping("/search/{query}")
	public ResponseEntity<List<Books>>searchBook
	(@PathVariable("query")String query){
		System.out.println("in author search");
		String url="http://DIGITAL-BOOK/api/books/v1/Books/search?query="+query+"";
		
		return new ResponseEntity<List<Books>>(rt.getForObject(url, List.class),HttpStatus.OK);
	}
	
	
	@GetMapping("/{bookId}")
	public Books findById(@PathVariable int bookId) {
		
		String url="http://DIGITAL-BOOK/api/books/v1/Books/"+bookId+"";
		return rt.getForObject(url, Books.class);
	}
	
	//update book data//-----
	@PutMapping("update/{bookId}")
	public Books updateBook(@PathVariable int bookId,@RequestBody com.cog.model.Books book){
	
		String url="http://DIGITAL-BOOK/api/books/v1/Books/update/"+bookId+"";
		rt.put(url, book, Books.class);
		
		return findById(bookId);
	}
	
	//getAll Books//
	@GetMapping("/findAll")
	 public ResponseEntity<List<Books>>findAll(){
		String url="http://DIGITAL-BOOK/api/books/v1/Books/getAllBooks";
		return new ResponseEntity<List<Books>>
		(rt.getForObject(url, List.class),HttpStatus.OK);
		
	}
	
}
