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
	public Categories getById(@PathVariable(value="id") long id){
		return categoriesService.findById(id);
	}	
	
	@PostMapping(value = "/categories/register")
	public Categories create(@RequestBody @Valid Categories categories) {
		return categoriesService.save(categories);
	}
	
	@PutMapping(value = "/categories/update/{id}")
	public Categories update (@PathVariable Long id, @RequestBody @Valid Categories categories) {
		return  this.categoriesService.update(categories);
	}
	
	@DeleteMapping(value = "/categories/delete/{id}")
	public void delete(@PathVariable Long id) {
		categoriesService.deleteById(id);
	}
	
	@PutMapping(value = "/categories/deactive/{id}")
	public Categories deactive (@PathVariable Long id) {
		Categories categories = categoriesService.findById(id);
		categories.setActive(false);
		return  this.categoriesService.update(categories);
	}

}
