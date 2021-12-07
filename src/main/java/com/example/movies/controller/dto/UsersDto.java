package com.example.movies.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.example.movies.entities.Languages;
import com.example.movies.entities.Users;
import com.example.movies.enums.ProfileEnum;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor 
@AllArgsConstructor
@Data
public class UsersDto {
	
	private Long id;
	
	private String name;
	
	private int cpf;
	
	private int cellPhone;
	
	private String email;
		
	private boolean active = true;
	
	private ProfileEnum profile;
	
	private Languages language;

	public UsersDto(Users users) {
		super();
		this.id = users.getId();
		this.name = users.getName();
		this.cpf = users.getCpf();
		this.cellPhone = users.getCellPhone();
		this.email = users.getEmail();
		this.active = users.isActive();
		this.profile = users.getProfile();
		this.language = users.getLanguage();
	}
	
	public static List<UsersDto> convert(List<Users> users) {
		return users.stream().map(UsersDto::new).collect(Collectors.toList());
	}
	
	public static List<UsersDto> convertUser(List<Users> users) {
		return users.stream().map(UsersDto::new).collect(Collectors.toList());
	}

	


}
