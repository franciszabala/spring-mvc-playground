
package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorldController {
	
	@RequestMapping (value="/helloDispatcher")
	public String sampleMethod1() {
		return "destination";
	}
	
//	@RequestMapping (value="/login", method=RequestMethod.GET)
//	public String setupLogin(Model model) {
//		LoginFromBean formBean = new LoginFromBean();
//		
//	}
	
//	@RequestMapping (value="/sampleParameterOnUrl/{samparam}")
//	public String sampleParameterOnUrl {
//		@ModelAttribute(value="samparam") String param, Model model) {
//			
//		}
//		
//	}
	//NOT AVAILABLE IN SPRING 3
	@RequestMapping(value="/sampleParameterOnList/{samparam}")
	public String sampleParameterOnList (
			@PathVariable String samparam, Model model) {
		model.addAttribute("message", samparam);
		return "destination";
	}
	

}
