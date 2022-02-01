package com.example.movies.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	public Users getById(@PathVariable(value="id") long id){
		return usersService.findById(id);
	}
	
	@PostMapping(value = "/users/register")
	public Users createUser(@RequestBody @Valid Users user) {
			return usersService.save(user);
	}
	
	@PutMapping(value = "/users/update/{id}")
	public Users update (@PathVariable Long id, @RequestBody @Valid Users user) {
		return  this.usersService.update(user);
	}
	
	@DeleteMapping(value = "users/delete/{id}")
	public void delete(@PathVariable Long id) {
		usersService.deleteById(id);
	}
	
	@PutMapping(value = "users/deactive/{id}")
	public Users deactive (@PathVariable Long id) {
		Users users = usersService.findById(id);
		users.setActive(false);
		return  this.usersService.update(users);
	}
	

	
	
}
