package com.example.movies.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.movies.entities.Users;
import com.example.movies.exceptions.BadRequestException;
import com.example.movies.repository.UsersRepository;

@Service
public class UsersService {
	
	@Autowired
	private UsersRepository usersRepository;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	public List<Users> findAll() {
		return usersRepository.findAll();
	}
	
	public List<Users> findById(long userId){
		return usersRepository.findById(userId);
	}
	
	public Users save(Users user) {
		if(usersRepository.existsByCpf(user.getCpf())) {
			throw new BadRequestException("CPF already exist in the database");
		}
		if(usersRepository.existsByEmail(user.getEmail())) {
			throw new BadRequestException("Email already exist in the database");
		}
		
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return usersRepository.save(user);
	}

	public Users update(Users users) {
		findById(users.getId());
		users.setPassword(passwordEncoder.encode(users.getPassword()));
		return usersRepository.saveAndFlush(users);
	}
	
	public void deleteById(Long id) {
		 usersRepository.deleteById(id);
	}
	
	
	
	
	


}
