package com.example.controller;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/admin")
public class ThirdController {
		
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/home")
	public String testMethodForJdbcTemplate(Model model) {
		UserObj user = userService.getUser("sherwin");
		model.addAttribute("message", user.getUsername());
		return "destination";
	}

}
