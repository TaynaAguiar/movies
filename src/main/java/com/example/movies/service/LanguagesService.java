package com.example.movies.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.movies.entities.Languages;
import com.example.movies.repository.LanguagesRepository;

@Service
public class LanguagesService {
	
	@Autowired
	private LanguagesRepository languagesRepository;
	
	public List<Languages> findAll(){
		return languagesRepository.findAll();
	}
	

}
