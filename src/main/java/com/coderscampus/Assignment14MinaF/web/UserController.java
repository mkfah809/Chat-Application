package com.coderscampus.Assignment14MinaF.web;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
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
	public String getWelcome(ModelMap model, Channel channel, User user) {
		if(channel.getChannelId() == null) {
			System.out.println("Channel id is empty");
			model.put("channel", new Channel());			
		} else {
			
		}
		return "welcome";
	}

	@PostMapping("/welcome")
	public String postWelcome(@RequestBody User user) {
		userService.createNewUser(user);
	    User saveUser = userService.saveUser(user);
	   Channel next = user.getChannels().iterator().next();
		userService.findById(user.getUserId());
	    return "redirect:/welcome";
	}

}
