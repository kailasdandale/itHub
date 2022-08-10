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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cog.model.Books;
import com.cog.service.BookService;

@RestController
@RequestMapping("/api/books/v1/Books")
@CrossOrigin("*")
public class BookController {

	@Autowired
	private BookService bservice;
	
	@GetMapping("/a")
	public String dumyData() {
		return "welcome";
	}
	
	//add Book//
	@PostMapping("/addBook")
	public ResponseEntity<Books>addnewBook(@RequestBody Books b){
		
		return new ResponseEntity<Books>(bservice.addBook(b),HttpStatus.OK);
	}
	//getAllBooks =only unblocked //
	@GetMapping("/getAllBooks")
	public ResponseEntity<List<Books>>getAllBook(){
		return new  ResponseEntity<List<Books>>
		(bservice.findAll(),HttpStatus.OK);
	}
	//findby bookId//
	@GetMapping("/{bookId}")
	public List<Books> getBooks(@PathVariable int bookId) {
		return bservice.findByBookId(bookId);
	}
	
	//serching API //
	@GetMapping("/search")//URL=http://ctsjava884.iiht.tech:1212/Books/search?query=550
	public ResponseEntity<List<Books>>searchBooks(@RequestParam("query")
	String query){
		System.out.println("in search method");
		return new ResponseEntity<List<Books>>(bservice.searchBooks(query),HttpStatus.OK);
	}
	
	//update book data//
	@PutMapping("/update/{bookId}")
	public void updateBook(@PathVariable int bookId,
			@RequestBody Books book){
		System.out.println("in update ");
		bservice.update(bookId,book);
		//return bservice.findByBookId(bookId);
	}
	@PutMapping("/blockUnlock/{bookId}")
	public ResponseEntity<Books>block_Unblock(@PathVariable int bookId, 
			@RequestBody Books book){
		
		return new ResponseEntity<Books>(bservice.blockUnblock(bookId,book),
				HttpStatus.ACCEPTED);
	}
	
}
