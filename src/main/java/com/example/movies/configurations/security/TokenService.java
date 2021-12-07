package com.example.movies.configurations.security;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.example.movies.entities.Users;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class TokenService {

	
	@Value("${movies.jwt.expiration}")
	private String expiration;
	
	@Value("${movies.jwt.secret}")
	private String secret;
	
	public String generateToken(Authentication authentication) {
		Users loggedUser = (Users) authentication.getPrincipal();
		Date today = new Date();
		Date expirantionDate = new Date(today.getTime() + Long.parseLong(expiration));
		
		return Jwts.builder()
				.setIssuer("API Movies")
				.setSubject(loggedUser.getId().toString())
				.setIssuedAt(today)
				.setExpiration(expirantionDate)
				.signWith(SignatureAlgorithm.HS256, secret)
				.compact();
	}

	public boolean isTokenValid(String token) {
		try {
			Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public Long getIdUsers(String token) {
		Claims claims = Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token).getBody();
		return Long.parseLong(claims.getSubject());
		
	}

	
	


}
