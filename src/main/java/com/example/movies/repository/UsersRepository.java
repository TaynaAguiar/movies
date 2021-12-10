package com.example.movies.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.movies.entities.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {
	
	Optional<Users>findByEmail(String email);

	List<Users> findById(long userId);	

	
}
