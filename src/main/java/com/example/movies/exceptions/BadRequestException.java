package com.example.movies.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadRequestException extends RuntimeException {
	
	private static final long serialVersionUID = 8890165475567997354L;

	public BadRequestException(String message) {
		super(message); 
	}
}