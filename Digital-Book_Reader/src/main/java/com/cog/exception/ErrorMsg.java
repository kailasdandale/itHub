package com.cog.exception;

import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.http.HttpStatus;

public class ErrorMsg {

	private String msg;
	private LocalDateTime d= LocalDateTime.now();
	public ErrorMsg(String message, String string, HttpStatus notFound) {
		// TODO Auto-generated constructor stub
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public LocalDateTime getD() {
		return d;
	}
	public void setD(LocalDateTime d) {
		this.d = d;
	}
	
}
