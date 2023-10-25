package com.jwt.example.jwtexample3.controller;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jwt.example.jwtexample3.model.User;
import com.jwt.example.jwtexample3.service.UserService;

@RestController
@RequestMapping("/home")
public class HomeController {
	
	
	@Autowired
	private UserService userService;
	
	//http://localhost:8082/home/user
	
	@GetMapping("/user")
	public List<User> getUser() {
		System.out.println("getting users");
		return userService.getUsers();
	}
	
	// The Principal represents the currently authenticated user. 
	//It contains information about the authenticated user, including their username.
	@GetMapping("/current-user")
	public String getLoggedInUser(Principal principal) {
		return principal.getName();
	}

}
