package com.example.movies.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@Api
@RestController
@RequestMapping(value = "/movies")
public class MoviesController {

	@GetMapping(value = "/hello")
	public String helloWord() {
		return "Hello World";
	}
}
