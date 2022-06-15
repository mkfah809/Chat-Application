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

	@GetMapping("/channels/{channelId}/{userId}")
	public String getChannel(@PathVariable Long channelId, @PathVariable Long userId, ModelMap model, Message message) {
		Channel findByChannelId = channelService.findByChannelId(channelId);
		model.put("channel", findByChannelId.getChannelId());
		User user = userService.findByUserId(userId);
		List<Message> findAllMessages = messageService.findAllMessages();
		model.put("messages", findAllMessages);
		return "channel";
	}

	@PostMapping("/channels/{channelId}/{userId}")
	public String postMessage(@RequestBody Message message) {
		messageService.saveMessage(message);

		return "redirect:/channels/" + message.getChannel().getChannelId();
	}
}
