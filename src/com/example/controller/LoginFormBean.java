package com.example.controller;

public class LoginFormBean {
	
	private LoginCredentials userLogin = new LoginCredentials();
	
	//get/set userLogin is tied to the code in jsp
	public LoginCredentials getUserLogin() {
		return userLogin;
	}
	
	public void setuserLogin(LoginCredentials userLogin){
		this.userLogin = userLogin;
		
	}
}

