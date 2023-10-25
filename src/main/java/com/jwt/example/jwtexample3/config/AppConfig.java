package com.jwt.example.jwtexample3.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class AppConfig {

	@Bean
	public UserDetailsService userDetailsService() {

		// The UserDetails interface is an essential part of Spring Security.
		// It contains information about a user, such as username, password, and roles.
		UserDetails user = User.builder().username("shivmohan").password(passwordEncoder().encode("shivmohan"))
				.roles("ADMIN").build();
		// It allows for a fluent and concise way to construct a UserDetails object
		UserDetails user1 = User.builder().username("anshika").password(passwordEncoder().encode("anshika"))
				.roles("ADMIN").build();

		// This method has var args variable so it contain as many parameters
		return new InMemoryUserDetailsManager(user, user1);
	}

	@Bean
	// PasswordEncoder is an interface for encoding and validating passwords.
	// BCryptPasswordEncoder is commonly used to encode user passwords before
	// storing them in a database.
	// When a user tries to log in, Spring Security uses the same encoder to hash
	// the entered password and
	// compare it with the stored hash.
	public PasswordEncoder passwordEncoder() {
		// BCrypt is a widely used password hashing algorithm.
		// It is designed to be computationally intensive and slow, making it difficult
		// for attackers to perform brute-force attacks.
		return new BCryptPasswordEncoder();
	}

	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration builder) throws Exception {
		return builder.getAuthenticationManager();
	}
}
