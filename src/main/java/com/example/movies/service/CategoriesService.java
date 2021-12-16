package com.example.movies.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.movies.entities.Categories;
import com.example.movies.repository.CategoriesRepository;

@Service
public class CategoriesService {
	
	@Autowired
	private CategoriesRepository categoriesRepository;

	public List<Categories> findAll() {
		return categoriesRepository.findAll();
	}

	public Categories save(@Valid Categories categories) {
		return categoriesRepository.save(categories);
	}

	public List<Categories> findById(long id) {
		return categoriesRepository.findById(id);
	}

	public Categories update(@Valid Categories categories) {
		return categoriesRepository.saveAndFlush(categories);
	}

	public void deleteById(Long id) {
		categoriesRepository.deleteById(id);
	}
	
	
	

}
