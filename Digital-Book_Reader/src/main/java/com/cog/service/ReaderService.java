package com.cog.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cog.Vo.ResponceTempleteVo;
import com.cog.exception.ReaderNotFound;
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

	public List<Books> getReaderWithBook(String email) {
		
		ResponceTempleteVo vo=new ResponceTempleteVo();
		Reader r=repo.findByEmail(email);
		System.out.println("inVo Service");
		String url="http://DIGITAL-BOOK/api/books/v1/Books/"+r.getBookId()+"";
		//http://ctsjava884.iiht.tech:1212/Books/
		List<Books> book=rt.getForObject(url, List.class);
				
		vo.setReader(r);
	//	vo.setBooks(book);
				
		return  book;
	}

	public Reader findByReaderId(int readerId) throws ReaderNotFound {
		
		Optional<Integer>r=Optional.ofNullable(readerId);
		if(r.isPresent()) {
		
			r.get();
			return	repo.findByReaderId(readerId);
		}
		throw new ReaderNotFound("reader not Found");	
		
		
	}

	
	
	
}
