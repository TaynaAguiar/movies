package com.example.movies.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.movies.entities.Movies;
import com.example.movies.repository.MoviesRepository;

@Service
public class MoviesService {

	@Autowired
	private MoviesRepository moviesRepository;
	
	public List<Movies> findAll() {
		return moviesRepository.findAll();
	}

	public Movies findById(long userId){
		return moviesRepository.findById(userId);
	}

	public Movies save(Movies movies) {
		return moviesRepository.save(movies);
	}

	public Movies update(Movies movies) {
		findById(movies.getId());
		return moviesRepository.saveAndFlush(movies);
	}

	public void deleteById(Long id) {
		moviesRepository.deleteById(id);
	}
}
