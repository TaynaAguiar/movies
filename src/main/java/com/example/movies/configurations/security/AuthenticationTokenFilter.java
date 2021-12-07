package com.example.movies.configurations.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import com.example.movies.entities.Users;
import com.example.movies.repository.UsersRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class AuthenticationTokenFilter extends OncePerRequestFilter {

	private TokenService tokenService;
	
	private UsersRepository repository;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		String token = recoveryToken(request);
		boolean valid = tokenService.isTokenValid(token);
		if(valid) {
			AutenticateUser(token);
		}
		filterChain.doFilter(request, response);
	}

	private void AutenticateUser(String token) {
		Long idUsers = tokenService.getIdUsers(token);
		Users users = repository.findById(idUsers).get();
		UsernamePasswordAuthenticationToken autentication = new UsernamePasswordAuthenticationToken(users, null, users.getAuthorities());
		SecurityContextHolder.getContext().setAuthentication(autentication);
	}

	private String recoveryToken(HttpServletRequest request) {
		String token = request.getHeader("Authorization");
		if(token == null || token.isEmpty() || !token.startsWith("Bearer ")) {
			return null;
		}
		
		return token.substring(7, token.length());
	}
	
	

}
