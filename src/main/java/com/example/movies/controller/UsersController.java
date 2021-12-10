package com.example.movies.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.movies.controller.dto.UsersDto;
import com.example.movies.entities.Users;
import com.example.movies.service.UsersService;

import io.swagger.annotations.Api;

@Api
@RestController
@RequestMapping(value = "/movies")
public class UsersController {

	@Autowired 
	private UsersService usersService;
	
	@GetMapping(value = "/users")
	public List<UsersDto> list(){
		List<Users> users = usersService.findAll();
		return UsersDto.convert(users);
	}

	
	@GetMapping(value = "/users/{id}")
	public List<UsersDto> listUser(@PathVariable(value="id") long id){
		
		List<Users> user = usersService.findById(id);
		if(user != null) {
			
			return UsersDto.convertUser(user);
		}
		
		List<Users> users = usersService.findAll();
		return UsersDto.convert(users);
	}
	
	/*@PostMapping(value = "/users/register")
	public ResponseEntity<Users> Register(@RequestBody @Valid Users users, UriComponentsBuilder uriBuilder) {
		usersService.save(users);
		
		URI uri = uriBuilder.path("/movies/users/register/{id}").buildAndExpand(users.getId()).toUri();
		return ResponseEntity.created(uri).body(users);
	}*/
	
	@PostMapping(value = "/users/register")
	public Users createUser(@RequestBody @Valid Users user) {
		return usersService.save(user);
	}
	
	@PutMapping(value = "/users/update/{id}")
	public Users update (@PathVariable Long id, @RequestBody @Valid Users user) {
		return  this.usersService.update(user);
	}

	
	
}
