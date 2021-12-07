package com.example.movies.configurations.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.movies.entities.Users;
import com.example.movies.repository.UsersRepository;

@Service
public class AuthenticationService implements UserDetailsService {

	@Autowired
	private UsersRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		Optional<Users>users = repository.findByEmail(userName);
		if(users.isPresent()) {
			return users.get();
		}
		throw new UsernameNotFoundException("Invalid data!");
	}

}
