package com.coderscampus.Assignment14MinaF.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.coderscampus.Assignment14MinaF.domain.User;
import com.coderscampus.Assignment14MinaF.service.UserService;

@Controller
public class UserController {
	@Autowired
	UserService userService;

	@GetMapping("/welcome")
	public String getWelcome(ModelMap model) {
		
		return "welcome";
	}

	@PostMapping("/welcome")
	public String postWelcome(@RequestBody User user) {
		userService.saveUser(user);
		return "redirect:/welcome";
	}
	
	
}
