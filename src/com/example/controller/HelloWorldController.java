
package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {
	
	@RequestMapping (value="/helloDispatcher")
	public String sampleMethod1() {
		return "destination";
	}
	
	@RequestMapping (value="/loginWithBean", method=RequestMethod.GET)
	public String setupLoginUsingBean(Model model) {
		LoginFormBean formBean = new LoginFormBean();
		
		formBean.getUserLogin().setUsername("default username");
		//send copy of login bean to the form
		model.addAttribute("loginBackingBean",formBean);
		return "login";
		
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String processLogin(
			LoginFormBean loginFormData,
			Model model) {
		model.addAttribute("message", loginFormData.getUserLogin().getUsername());
		return "destination";
	}
	
	
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
	
	@RequestMapping(value="/login", method=RequestMethod.GET) 
	public String setupLogin(Model model) {
		return "login";
	}
	
	@RequestMapping(value="/loginNormal", method=RequestMethod.POST)
	public String normalLogin(
				@RequestParam(value="username") String username,
				@RequestParam(value="password") String password,
				Model model) {
		model.addAttribute("message", username);
		
		return "destination";
	}

}
