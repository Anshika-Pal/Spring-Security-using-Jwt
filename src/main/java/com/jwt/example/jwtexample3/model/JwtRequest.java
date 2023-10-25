package com.jwt.example.jwtexample3.model;

public class JwtRequest {
	private String email;
	private String password;

	public String getEmail() {
		return email;
	}

	public JwtRequest setEmail(String email) {
		this.email = email;
		return this;
	}

	public String getPassword() {
		return password;
	}

	public JwtRequest setPassword(String password) {
		this.password = password;
		return this;
	}

	public JwtRequest(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}

	@Override
	public String toString() {
		return "JwtResponse [email=" + email + ", password=" + password + "]";
	}

	public JwtRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
}
