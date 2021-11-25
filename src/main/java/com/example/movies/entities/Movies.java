package com.example.movies.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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
	
	private String title;
	
	@Column(columnDefinition = "TEXT")
	private String synopsis;
	
	@Column(columnDefinition = "TEXT")
	private String image;
	
	private String date;
	
	private String duration;
	
	@ManyToOne
	@JoinColumn(name = "language_id")
	private Languages language;
	
	@ManyToOne
	@JoinColumn(name = "category_id")
	private Categories category;
	
}
