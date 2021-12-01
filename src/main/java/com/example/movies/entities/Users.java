
package com.example.movies.entities;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

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
public class Users implements UserDetails {

	private static final long serialVersionUID = 1L;

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
	private Collection<? extends GrantedAuthority> profile;
	
	@ManyToOne
	@JoinColumn(name = "language_id")
	private Languages language;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.profile;
	}

	@Override
	public String getUsername() {
		return this.email;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
}
