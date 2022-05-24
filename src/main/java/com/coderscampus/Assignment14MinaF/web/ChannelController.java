package com.coderscampus.Assignment14MinaF.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.coderscampus.Assignment14MinaF.domain.Message;
import com.coderscampus.Assignment14MinaF.domain.User;
import com.coderscampus.Assignment14MinaF.service.ChannelService;
import com.coderscampus.Assignment14MinaF.service.MessageService;
import com.coderscampus.Assignment14MinaF.service.UserService;

@Controller
public class ChannelController {

	@Autowired
	ChannelService channelService;
	@Autowired
	UserService userService;
	@Autowired
	MessageService messageService;

	@GetMapping("/channels/{channelId}")
	public String getChannel(@PathVariable Long channelId, ModelMap model) {
		model.put("channels", channelService.findByChannelId(channelId));
		model.put("messages",messageService.findAllMessages());
		
		return "channel";
	} 
 
	
	@PostMapping("/channels/{channelId}")
	public String postMessage(@RequestBody Message message, Long channelId, Long MessageId) {
		messageService.save(message, channelId);
		System.out.println(message.getUser().getUserName());
		System.out.println(message.getMessageContent());

		return "redirect:/channels/" + message.getChannel().getChannelId();
	}
}
