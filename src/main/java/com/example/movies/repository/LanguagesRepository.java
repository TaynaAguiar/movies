package com.example.movies.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.movies.entities.Languages;

@Repository
public interface LanguagesRepository extends JpaRepository<Languages, Long>{


}
