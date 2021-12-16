package com.example.movies.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.movies.entities.Movies;

@Repository
public interface MoviesRepository extends JpaRepository<Movies, Long>{

	Movies findById(long userId);
	
}
