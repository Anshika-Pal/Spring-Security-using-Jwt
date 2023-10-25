package com.jwt.example.jwtexample3.model;

public class JwtResponse {
	private String jwtToken;
	private String username;

	public String getJwtToken() {
		return jwtToken;
	}

	public JwtResponse setJwtToken(String jwtToken) {
		this.jwtToken = jwtToken;
		return this;
	}

	public String getUsername() {
		return username;
	}

	public JwtResponse setUsername(String username) {
		this.username = username;
		return this;
	}

	public JwtResponse(String jwtToken, String username) {
		super();
		this.jwtToken = jwtToken;
		this.username = username;
	}

	public JwtResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "JwtResponse [jwtToken=" + jwtToken + ", username=" + username + "]";
	}

}
