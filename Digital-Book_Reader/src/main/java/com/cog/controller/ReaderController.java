package com.cog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cog.Vo.ResponceTempleteVo;
import com.cog.model.Books;
import com.cog.model.Reader;
import com.cog.service.ReaderService;

@RestController
@RequestMapping("/reader")
public class ReaderController {

	@Autowired
	private RestTemplate rt;
	@Autowired
	private ReaderService rservice;
	
	//reader can search book//
	@GetMapping("/search/{query}")
	public ResponseEntity<List<Books>>searchBook
	(@PathVariable("query")String query){
		String url="http://DIGITAL-BOOK/Books/search?query="+query+"";
		
		return new ResponseEntity<List<Books>>(rt.getForObject(url, List.class),HttpStatus.OK);
	}
	
	//reader can buy book//
	@PostMapping("/subscribe")//click on Book save BookId with Reader
	public ResponseEntity<Reader>buyBook(@RequestBody Reader r){
		
		return new ResponseEntity<Reader>(rservice.save(r),HttpStatus.CREATED);
	}
	@GetMapping("/{readerId}")
	public Reader getReader(@PathVariable int readerId) {
		return rservice.findByReaderId(readerId);
	}
	
	//find subscribe books//
	@GetMapping("/findsubscribeBook/{readerId}")
	public ResponceTempleteVo getReaderWithBook(@PathVariable int readerId) {
		System.out.println("in reader controller");
	return	rservice.getReaderWithBook(readerId);
		
	}
	
}
