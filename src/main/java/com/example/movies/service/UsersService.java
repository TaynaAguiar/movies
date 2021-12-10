package com.example.movies.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

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
	
	public Users save(@RequestBody Users user) {
		return usersRepository.save(user);
	}

	public Users update(Users users) {
		findById(users.getId());
		return usersRepository.saveAndFlush(users);
	}

}
