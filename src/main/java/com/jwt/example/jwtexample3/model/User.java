package com.jwt.example.jwtexample3.model;

public class User {

	private String userIdString;
	private String name;
	private String email;
	
	public String getUserIdString() {
		return userIdString;
	}
	public void setUserIdString(String userIdString) {
		this.userIdString = userIdString;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "User [userIdString=" + userIdString + ", name=" + name + ", email=" + email + "]";
	}
	public User(String userIdString, String name, String email) {
		super();
		this.userIdString = userIdString;
		this.name = name;
		this.email = email;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
