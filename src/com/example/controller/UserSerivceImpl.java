package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("userService")
public class UserSerivceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Override
	public UserObj getUser(String username) {
		// TODO Auto-generated method stub
		return userDao.getUser(username);
	}

}
