package com.cog.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cog.Vo.ResponceTempleteVo;
import com.cog.model.Books;
import com.cog.model.Reader;
import com.cog.repository.ReaderRepo;

@Service
public class ReaderService {

	@Autowired
	private ReaderRepo repo;

	@Autowired
	private RestTemplate rt;
	
	public Reader save(Reader r) {
		
		return repo.save(r);
	}

	public ResponceTempleteVo getReaderWithBook(int readerId) {
		
		ResponceTempleteVo vo=new ResponceTempleteVo();
		Reader r=repo.findByReaderId(readerId);
		System.out.println("inVo Service");
		String url="http://DIGITAL-BOOK/api/books/v1/Books/"+r.getBookId()+"";
		//http://ctsjava884.iiht.tech:1212/Books/
		Books book=rt.getForObject(url, Books.class);
				
		vo.setReader(r);
		vo.setBooks(book);
				
		return vo;
	}

	public Reader findByReaderId(int readerId) {
		// TODO Auto-generated method stub
		return repo.findByReaderId(readerId);
	}
	
	
}
