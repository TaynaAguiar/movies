package com.example.movies.entities;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Movies {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message = "This field cannot be null")
	@NotEmpty(message = "This field cannot be empty")
	private String title;
	
	@NotNull(message = "This field cannot be null")
	@NotEmpty(message = "This field cannot be empty")
	@Column(columnDefinition = "TEXT")
	private String synopsis;
	
	@Column(columnDefinition = "TEXT")
	private String image;
	
	@NotNull(message = "This field cannot be null")
	@NotEmpty(message = "This field cannot be empty")
	private String date;
	
	@NotNull(message = "This field cannot be null")
	@NotEmpty(message = "This field cannot be empty")
	private String duration;
	
	@ManyToOne
	@JoinColumn(name = "language_id")
	private Languages language;
	
	@ManyToOne
	@JoinColumn(name = "category_id")
	private Categories category;

	
	
}
