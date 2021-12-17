package com.example.movies.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.movies.entities.Categories;

@Repository
public interface CategoriesRepository extends JpaRepository<Categories, Long>  {

	Categories findById(long categoriesId);
}
