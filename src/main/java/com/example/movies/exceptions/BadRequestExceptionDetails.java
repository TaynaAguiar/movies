package com.example.movies.exceptions;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BadRequestExceptionDetails {
	
	private String title;
	private int status;
	private String message;
	
	/*public static ResponseEntity<BadRequestExceptionDetails> builder() {
		// TODO Auto-generated method stub
		return null;
	}*/

}
