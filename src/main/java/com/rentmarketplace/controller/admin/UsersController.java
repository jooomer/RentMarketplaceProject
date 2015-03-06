package com.rentmarketplace.controller.admin;

import java.security.Principal;

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
@RequestMapping(value = "/users")
public class UsersController {
	
	@Autowired
	private UserService userService;
		
	@RequestMapping
	public String users(Model model) {
		model.addAttribute("users", userService.findAll());
		return "users";
		
	}
	
	@RequestMapping(value = "/{id}")
	public String detail(Model model, @PathVariable int id) {
		model.addAttribute("user", userService.findOneWithProducts(id));
		return "user-detail";
	}
	
}
