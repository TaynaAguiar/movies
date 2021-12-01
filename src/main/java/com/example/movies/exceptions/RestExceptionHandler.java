package com.example.movies.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler {
	
	@ExceptionHandler(BadRequestException.class)
	public ResponseEntity<BadRequestExceptionDetails> handlerBadrequestException(BadRequestException bre){
			return new ResponseEntity<>(
				BadRequestExceptionDetails.builder()
					.status(HttpStatus.BAD_REQUEST.value())
					.title("BadRequestException")
					.message(bre.getClass().getName())
					.build(), HttpStatus.BAD_REQUEST);
					
	}

}
