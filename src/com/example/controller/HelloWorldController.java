
package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorldController {
	
	@RequestMapping (value="/helloDispatcher")
	public String sampleMethod1() {
		return "destination";
	}

}
