package com.example.controller;

public interface UserDao {
	UserObj getUser(String username);
	
	UserObj getUserDifferently(String username);

}