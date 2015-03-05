package com.rentmarketplace.controller.common;


import java.security.Principal;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.rentmarketplace.model.entity.User;
import com.rentmarketplace.service.UserService;

/**
 * Servlet implementation class Controller
 */
@Controller
@SessionAttributes("user")
public class IndexController {

	private final static Logger LOGGER = LogManager.getLogger(IndexController.class);

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String viewMainPage() {
		return "index";
	}
	
	
}
