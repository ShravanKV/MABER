package com.example.demo.entity;

public class verifyrequest {
	private String email;
	private String password;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public verifyrequest(String email, String password) {
	
		this.email = email;
		this.password = password;
	}
	public verifyrequest() {
	
	}
	@Override
	public String toString() {
		return "verifyrequest [email=" + email + ", password=" + password + "]";
	}
	

}
