package com.coderscampus.Assignment14MinaF.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.coderscampus.Assignment14MinaF.domain.Channel;
import com.coderscampus.Assignment14MinaF.domain.User;
import com.coderscampus.Assignment14MinaF.service.ChannelService;
import com.coderscampus.Assignment14MinaF.service.UserService;

@Controller
public class UserController {
	@Autowired
	UserService userService;
	@Autowired
	ChannelService channelService;

	@GetMapping("/welcome")
	public String getWelcome(ModelMap model, User user) {
		if (user.getUserId() != null) {
			model.put("user", userService.findByUserId(user.getUserId()));
		}
		if (user.getUserId() == null) {
			userService.saveUser(user);
		}
		model.put("channel", channelService.findAllChannels().get(0));
		System.out.println("username is " + user.getUserName());
		System.out.println("userId is " + user.getUserId());

		return "welcome";
	}

	@PostMapping("/welcome")
	public String postWelcome(@RequestBody User user, ModelMap model) {
		userService.saveUser(user);
		model.put("user", userService.findByUserId(user.getUserId()));
		return "redirect:/welcome";
	}

}
