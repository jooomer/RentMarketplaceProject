package com.rentmarketplace.controller.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rentmarketplace.model.entity.User;
import com.rentmarketplace.service.UserService;

@Controller
public class RegisterController {
	
	@Autowired
	private UserService userService;
	
	@ModelAttribute("user")
	public User construct() {
		return new User();
	}
		
	@RequestMapping(value = "/register")
	public String showRegister() {
		return "register";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String doRegister(@ModelAttribute("user") User user) {
		userService.save(user);
		return "redirect:/register?success=true";
	}

}
