
package com.example.movies.entities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CPF;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
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
	
	@NotNull(message = "This field cannot be null")
	@NotEmpty(message = "This field cannot be empty")
	private String name;
	
	@CPF
	private String cpf;
	
	@NotNull(message = "This field cannot be null")
	private String cellPhone;
	
	@NotNull(message = "This field cannot be null")
	@Email
	private String email;
	
	@NotNull(message = "This field cannot be null")
	@NotEmpty(message = "This field cannot be empty")
	private String password;
	
	private boolean active = true;
	
	@Column(name = "profile", nullable = false)
	@Enumerated(EnumType.STRING)
	private ProfileEnum profile;
	
	@ManyToOne
	@JoinColumn(name = "language_id")
	private Languages language;

	@Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> list = new ArrayList<GrantedAuthority>();

        list.add(new SimpleGrantedAuthority(profile.name()));

        return list;
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
