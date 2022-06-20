package com.coderscampus.Assignment14MinaF.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.coderscampus.Assignment14MinaF.domain.User;
import com.coderscampus.Assignment14MinaF.service.ChannelService;
import com.coderscampus.Assignment14MinaF.service.UserService;

@Controller
public class UserController {
	@Autowired
	UserService userService;
	@Autowired
	ChannelService channelService;

	@RequestMapping("/")
	public String getRedirectWelcomePage() {
		return ("redirect://localhost:8080/welcome");
	}

	@GetMapping("/welcome")
	public String getWelcome(ModelMap model, User user) {

		model.put("user", userService.findByUserId(userService.saveUser(user).getUserId()));
		model.put("channel", user.getChannels().get(0));
		return "welcome";
	}

	@PostMapping("/welcome")
	public String postWelcome(@RequestBody User user) {
		userService.saveUser(user);

		return "redirect://welcome";
	}

}
