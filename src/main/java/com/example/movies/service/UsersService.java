package com.example.movies.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.movies.entities.Users;
import com.example.movies.repository.UsersRepository;

@Service
public class UsersService {
	
	@Autowired
	private UsersRepository usersRepository;
	
	public List<Users> findAll() {
		return usersRepository.findAll();
	}
	
	public List<Users> findById(long userId){
		return usersRepository.findById(userId);
	}

	public void save(Users users) {
		usersRepository.save(users);
	}
	

}
