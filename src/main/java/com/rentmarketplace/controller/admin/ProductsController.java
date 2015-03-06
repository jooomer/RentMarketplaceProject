package com.rentmarketplace.controller.admin;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rentmarketplace.model.entity.Product;
import com.rentmarketplace.model.entity.User;
import com.rentmarketplace.service.ProductService;
import com.rentmarketplace.service.UserService;

@Controller
@RequestMapping("/products")
public class ProductsController {
	
	@Autowired
	private ProductService productService;
		
	@RequestMapping
	public String users(Model model) {
		List<Product> products = productService.findAll();
		model.addAttribute("products", products);
		return "products";
		
	}
	
	@RequestMapping(value = "/{id}")
	public String detail(Model model, @PathVariable int id) {
		model.addAttribute("product", productService.findOne(id));
		return "product-detail";
	}
	
}
