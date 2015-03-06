package com.rentmarketplace.controller.registered;

import java.security.Principal;
import java.util.Date;
import java.util.Map;

import javax.validation.Valid;

import jdk.nashorn.internal.objects.annotations.Constructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rentmarketplace.model.entity.Product;
import com.rentmarketplace.model.entity.User;
import com.rentmarketplace.repository.ProductRepository;
import com.rentmarketplace.service.ProductService;
import com.rentmarketplace.service.ProductTypeService;
import com.rentmarketplace.service.UserService;

@Controller
public class AddProductController {
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private ProductTypeService productTypeService;
	
	@Autowired
	private UserService userService;
	
	@ModelAttribute("product")
	public Product construct() {
		return new Product();
	}
		
	@RequestMapping(value = "/add-product")
	public String showAddProduct(Model model) {
		model.addAttribute("listOfProductTypes", productTypeService.findAll());
		return "add-product";
		
	}
	
	@RequestMapping(value = "/add-product", method = RequestMethod.POST)
	public String doAddProduct(@Valid @ModelAttribute("product") Product product, BindingResult result, Principal principal, Model model) {
		if (result.hasErrors()) {
			return showAddProduct(model);
		}
		String name = principal.getName();
		product.setPublishedDate(new Date());
		productService.save(product, name);
		product = productService.findOneByName(product.getName());
		int id = product.getId();
		return "redirect:/my-products/" + id + "?success=true";
	}
	
}
