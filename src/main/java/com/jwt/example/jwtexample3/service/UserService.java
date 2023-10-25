package com.jwt.example.jwtexample3.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.jwt.example.jwtexample3.model.User;

@Service
public class UserService {

	private List<User> store = new ArrayList<>();

	public UserService() {

		// UUID.randomUUID() is a method in Java that generates a random Universally
		// Unique Identifier (UUID).
		// '550e8400-e29b-41d4-a716-446655440000' hexadecimal string separated by dashes
		store.add(new User(UUID.randomUUID().toString(), "Anshika", "Anshikapal@186gmail.com"));
		store.add(new User(UUID.randomUUID().toString(), "Kanchan", "Kancgan@gmail.com"));
		store.add(new User(UUID.randomUUID().toString(), "Preeti", "PreetiDiwakar@gmail.com"));
		store.add(new User(UUID.randomUUID().toString(), "Awantika", "Awantika@181gmail.com"));
	}

	public List<User> getUsers() {
		return store;
	}
}
