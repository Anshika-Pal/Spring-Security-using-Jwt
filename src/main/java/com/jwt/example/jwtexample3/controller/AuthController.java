package com.jwt.example.jwtexample3.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jwt.example.jwtexample3.model.JwtRequest;
import com.jwt.example.jwtexample3.model.JwtResponse;
import com.jwt.example.jwtexample3.security.JwtHelper;

@RestController
@RequestMapping("/auth")
public class AuthController {

	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	private AuthenticationManager manager;

	@Autowired
	private JwtHelper helper;

	private Logger logger = LoggerFactory.getLogger(AuthController.class);

	@PostMapping("/login")
	public ResponseEntity<JwtResponse> login(@RequestBody JwtRequest request) {
		System.out.println("Request1-"+request);
		this.doAuthenticate(request.getEmail(), request.getPassword());
		System.out.println("Request2-"+request);

		UserDetails userDetails = userDetailsService.loadUserByUsername(request.getEmail());
		System.out.println("Request3-"+request);
		System.out.println("Request3-"+userDetails);
		String token = this.helper.generateToken(userDetails);

		System.out.println("Request4-"+request);
		JwtResponse response = new JwtResponse().setJwtToken(token).setUsername(userDetails.getUsername());
		System.out.println("Request5-"+request);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	private void doAuthenticate(String email, String password) {

		UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(email, password);
		try {
			manager.authenticate(authentication);

		} catch (BadCredentialsException e) {
			throw new BadCredentialsException(" Invalid Username or Password  !!");
		}

	}
}
