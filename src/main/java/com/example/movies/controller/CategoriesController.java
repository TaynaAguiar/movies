package com.example.movies.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.movies.entities.Categories;
import com.example.movies.service.CategoriesService;

import io.swagger.annotations.Api;

@Api
@RestController
@RequestMapping(value = "/movies")
public class CategoriesController {
	
	@Autowired
	private CategoriesService categoriesService;
	
	@GetMapping(value = "/categories")
	public List<Categories> list(){
		return categoriesService.findAll();
	}
	
	@GetMapping(value = "/categories/{id}")
	public List<Categories> listCategories(@PathVariable(value="id") long id){
		
		List<Categories> movies = categoriesService.findById(id);
		if(movies != null) {
			
			return categoriesService.findById(id);
		}
		 
		return categoriesService.findAll();
	}
	
	@PostMapping(value = "/categories/register")
	public Categories create(@RequestBody @Valid Categories categories) {
		return categoriesService.save(categories);
	}
	
	@PutMapping(value = "/categories/update/{id}")
	public Categories update (@PathVariable Long id, @RequestBody @Valid Categories categories) {
		return  this.categoriesService.update(categories);
	}
	
	
	

}
