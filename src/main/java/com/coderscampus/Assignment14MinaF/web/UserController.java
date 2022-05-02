package com.coderscampus.Assignment14MinaF.web;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.coderscampus.Assignment14MinaF.domain.Channel;
import com.coderscampus.Assignment14MinaF.domain.User;
import com.coderscampus.Assignment14MinaF.repository.UserRepository;
import com.coderscampus.Assignment14MinaF.service.ChannelService;
import com.coderscampus.Assignment14MinaF.service.UserService;

@Controller
public class UserController {
	@Autowired
	UserService userService;
	@Autowired
	ChannelService channelService;
@Autowired
	UserRepository userRepo;
	@GetMapping("/welcome")
	public String getWelcome(ModelMap model) {
		List<Channel> findAllChannels = channelService.findAllChannels();
		
		model.put("channels", findAllChannels);

		return "welcome";
	}

	@PostMapping("/welcome")
	public String postWelcome(@RequestBody User user) {
		userService.createNewUser(user);
		userService.saveUser(user);
	    return "redirect:/welcome";
	}


	@GetMapping("/channels/{channelId}")
	public String getChannel(ModelMap model, @PathVariable Long channelId) {
		Channel findByChannelId = channelService.findById(channelId);
		System.out.println("XXX " + findByChannelId);
		model.put("channel", findByChannelId);
		return "channel";
	}
}
