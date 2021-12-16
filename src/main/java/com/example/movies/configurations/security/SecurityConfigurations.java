package com.example.movies.configurations.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.example.movies.repository.UsersRepository;

@EnableWebSecurity
@Configuration
public class SecurityConfigurations extends WebSecurityConfigurerAdapter {

	@Autowired
	private AuthenticationService authenticationService;
	
	@Autowired
	private TokenService tokenService;
	
	@Autowired
	private UsersRepository usersRepository;
	
	@Override
	@Bean
	protected AuthenticationManager authenticationManager() throws Exception {
		return super.authenticationManager();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(authenticationService).passwordEncoder(new BCryptPasswordEncoder());
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers(HttpMethod.GET, "/swagger-ui/index.html").permitAll() 
		.antMatchers(HttpMethod.GET, "/movies/users").access("hasRole('VISITOR')")
		.antMatchers(HttpMethod.GET, "/movies/users/{id}").access("hasRole('VISITOR')")
		.antMatchers(HttpMethod.GET, "/movies/categories").access("hasRole('VISITOR')")
		.antMatchers(HttpMethod.GET, "/movies/categories/{id}").access("hasRole('VISITOR')")
		.antMatchers(HttpMethod.GET, "/movies/list").permitAll()
		.antMatchers(HttpMethod.GET, "/movies/list/{id}").permitAll()
		.antMatchers(HttpMethod.POST, "/movies/categories/register").access("hasRole('ADMINISTRATOR')")
		.antMatchers(HttpMethod.POST, "/movies/users/register").access("hasRole('ADMINISTRATOR')")
		.antMatchers(HttpMethod.POST, "/movies/register").permitAll()
		.antMatchers(HttpMethod.PUT, "/movies/categories/update/{id}").access("hasRole('ADMINISTRATOR')")
		.antMatchers(HttpMethod.PUT, "/movies/users/update/{id}").access("hasRole('ADMINISTRATOR')")
		.antMatchers(HttpMethod.PUT, "/movies/update/{id}").access("hasRole('ADMINISTRATOR')")
		.antMatchers(HttpMethod.PUT, "/movies/users/deactive/{id}").permitAll()
		.antMatchers(HttpMethod.PUT, "/movies/categories/deactive/{id}").permitAll()
		.antMatchers(HttpMethod.PUT, "/movies/deactive/{id}").permitAll()
		.antMatchers(HttpMethod.DELETE, "/movies/users/delete/{id}").access("hasRole('ADMINISTRATOR')")
		.antMatchers(HttpMethod.DELETE, "/movies/delete/{id}").access("hasRole('ADMINISTRATOR')")
		.antMatchers(HttpMethod.DELETE, "/movies/categories/delete/{id}").access("hasRole('ADMINISTRATOR')")
		.antMatchers(HttpMethod.POST, "/auth").permitAll()
		.anyRequest().authenticated()
		.and().csrf().disable()
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		.and().addFilterBefore(new AuthenticationTokenFilter(tokenService, usersRepository), UsernamePasswordAuthenticationFilter.class);
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
	}
		
	@Bean
	public BCryptPasswordEncoder passwordEncoder(){
	    return new BCryptPasswordEncoder();
	}
	
	
}
