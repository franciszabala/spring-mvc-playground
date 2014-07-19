package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/admin")
public class SecondController {
	
	@RequestMapping(value="/home")
	public String sampleOfSubUrl(Model model) {
		String myMessage = "Hello Wolt";
		model.addAttribute("message", myMessage);
		return "destination";
	}
}
