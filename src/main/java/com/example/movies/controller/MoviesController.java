package com.example.movies.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.movies.entities.Movies;
import com.example.movies.service.MoviesService;

import io.swagger.annotations.Api;

@Api
@RestController
@RequestMapping(value = "/movies")
public class MoviesController {

	@Autowired
	private MoviesService moviesService;
	
	@GetMapping(value = "/list")
	public List<Movies> listMovies(){
		return moviesService.findAll();
	}
	
	@GetMapping(value = "/list/{id}")
	public Movies getById(@PathVariable(value="id") long id){
		return moviesService.findById(id);
	}
	
	@PostMapping(value = "/register")
	public Movies createMovies(@RequestBody @Valid Movies movies) {
		return moviesService.save(movies);
	}
	
	@PutMapping(value = "/update/{id}")
	public Movies update (@PathVariable Long id, @RequestBody @Valid Movies movies) {
		return  this.moviesService.update(movies);
	}
	
	@DeleteMapping(value = "/delete/{id}")
	public void delete(@PathVariable Long id) {
		moviesService.deleteById(id);
	}
	
	@PutMapping(value = "/deactive/{id}")
	public Movies deactive (@PathVariable Long id) {
		Movies movies = moviesService.findById(id);
		movies.setActive(false);
		return  this.moviesService.update(movies);
	}
}
