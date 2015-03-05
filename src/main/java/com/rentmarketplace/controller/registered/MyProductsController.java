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
import com.rentmarketplace.service.ProductService;
import com.rentmarketplace.service.UserService;

@Controller
public class MyProductsController {
	
	@Autowired
	private ProductService productService;
		
	@RequestMapping(value = "/my-products")
	public String showMyProducts(Model model, Principal principal) {
		String name = principal.getName();
		model.addAttribute("myProducts", productService.findAllByUserName(name));
		return "my-products";
		
	}
	
	@RequestMapping(value = "/my-products/{id}")
	public String detail(Model model, @PathVariable int id) {
		model.addAttribute("myProduct", productService.findOne(id));
		return "product-detail";
	}
	
}
