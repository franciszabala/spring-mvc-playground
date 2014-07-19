package com.example.controller;

public class LoginFormBean {
	
	private LoginCredentials userLogin = new LoginCredentials();
	
	//if null, jsp can't find it
	//it has to exist even if it's empty
	//results in a null pointer exception in jsp
	//private LoginCredentials userLogin;
	
	//get/set userLogin is tied to the code in jsp
	public LoginCredentials getUserLogin() {
		return userLogin;
	}
	//get and setter used by jsp, and it looks like it's accessing a public field
	public void setuserLogin(LoginCredentials userLogin){
		this.userLogin = userLogin;
		
	}
}

