package com.example.movies.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.movies.entities.Languages;
import com.example.movies.service.LanguagesService;

import io.swagger.annotations.Api;

@Api
@RestController
@RequestMapping(value="/movies")
public class LanguagesController {

	@Autowired
	private LanguagesService languagesService;
	
	@GetMapping(value = "/languages")
	public List<Languages> list(){
		return languagesService.findAll();
	}
	
	
}
