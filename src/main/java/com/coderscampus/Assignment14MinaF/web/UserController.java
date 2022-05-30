package com.coderscampus.Assignment14MinaF.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

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
	public String getWelcome(ModelMap model) {
		model.put("channels", channelService.findAllChannels());
		return "welcome";
	}

	@PostMapping("/welcome")
	public String postWelcome(ModelMap model, @RequestBody User user, Channel channel) {

		User saveUser = userService.saveUser(user);
		System.out.println("userId " + user.getUserId());
		model.put("user", userService.findByUserId(user.getUserId()));
		return "redirect:/welcome";
	}

}
