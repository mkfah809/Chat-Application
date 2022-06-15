package com.coderscampus.Assignment14MinaF.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

		userService.saveUser(user);

		model.put("user",
				userService.findByUserId(userService.findAll().get(userService.findAll().size() - 2).getUserId()));
		model.put("channel", user.getChannels().get(0));
		return "welcome";
	}

	@PostMapping("/welcome")
	public String postWelcome(@RequestBody User user) {
		userService.saveUser(user);
		return "redirect:/welcome";
	}

}
