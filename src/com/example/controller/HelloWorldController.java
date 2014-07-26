
package com.example.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
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
	
	@RequestMapping (value="/login2", method=RequestMethod.GET)
	public String setupLoginUsingBean2(Model model) {
		FormBeanValidator formBean = new FormBeanValidator();
		
		formBean.setUsername("default username new");
		//send copy of login bean to the form
		model.addAttribute("arbitaryBeanName",formBean);
		return "login2";
		
	}
	
	@RequestMapping(value="/login2", method=RequestMethod.POST)
	public String processLoginValidator(
			@ModelAttribute("arbitaryBeanName") @Valid FormBeanValidator loginFormData, 
			BindingResult result,
			Model model)
			{
		
		//BindingResult first 
		//then the Model
				if(result.hasErrors()) {
					System.out.println("I haz errors");
					return "login2";
				} else {
					System.out.println("This is not error");
				}
		
				model.addAttribute("message", loginFormData.getUsername());
				return "destination";
				
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
