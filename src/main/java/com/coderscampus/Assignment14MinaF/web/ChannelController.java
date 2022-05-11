package com.coderscampus.Assignment14MinaF.web;

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

@Controller
public class ChannelController {

	@Autowired
	ChannelService channelService;

	@GetMapping("/channels/{channelId}")
	public String getChannel(@PathVariable Long channelId, ModelMap model) {
		model.put("channels", channelService.findByChannelId(channelId));
		return "channel";
	}
	
	@PostMapping("/channels/{channelId}")
	public String postMessage(@RequestBody User user) {
		System.out.println(user);
		return "redirect:/channels/{channelId}";
	}
	
}
