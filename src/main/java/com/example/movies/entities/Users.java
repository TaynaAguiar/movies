package com.example.movies.entities;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.example.movies.enums.ProfileEnum;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Users {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	private int cpf;
	
	private int cellPhone;
	
	private String email;
	
	private String password;
	
	private boolean active = true;
	
	@Enumerated(EnumType.STRING)
	private ProfileEnum profile;
	
	@ManyToOne
	@JoinColumn(name = "language_id")
	private Languages language;
}
