package com.rentmarketplace.controller.registered;

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
public class AccountController {
	
	@Autowired
	private UserService userService;
	
	@ModelAttribute("user")
	public User construct() {
		return new User();
	}
	
	@RequestMapping(value = "/account")
	public String showAccount(Model model, Principal principal) {
		String name = principal.getName();
		model.addAttribute("user", userService.findOneWithProducts(name));
		return "account";
	}
	
/*
	@RequestMapping(value = "/account-update")
	public String showAccountUpdate(Model model, Principal principal) {
		String name = principal.getName();
		model.addAttribute("user", userService.findOneWithOffers(name));
		return "account-update";
	}

	@RequestMapping(value = "/account-update", method = RequestMethod.POST)
	public String doAccountUpdate(@ModelAttribute("user") User user) {
		userService.save(user);
		return "redirect:/account?success=true";
	}
*/	
	
}
