package com.cog.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Reader {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int readerId;
	private String readerName;
	private String email;
	private int bookId;

	public int getReaderId() {
		return readerId;
	}
	public Reader() {
		super();
		
	}
	public Reader(int readerId, String readerName, String email, int bookId) {
		super();
		this.readerId = readerId;
		this.readerName = readerName;
		this.email = email;
		this.bookId = bookId;
	}
	public void setReaderId(int readerId) {
		this.readerId = readerId;
	}
	public String getReaderName() {
		return readerName;
	}
	public void setReaderName(String readerName) {
		this.readerName = readerName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	
	
	
	
	
	
}
