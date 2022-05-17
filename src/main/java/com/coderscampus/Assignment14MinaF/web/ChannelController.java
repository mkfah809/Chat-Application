package com.coderscampus.Assignment14MinaF.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.coderscampus.Assignment14MinaF.domain.Channel;
import com.coderscampus.Assignment14MinaF.domain.Message;
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
	public String getChannel(@PathVariable Long channelId, ModelMap model, Message message) {
		model.put("channels", channelService.findByChannelId(channelId));
		return "channel";
	}

	@PostMapping("/channels/{channelId}")

	public String postMessage(ModelMap model,@RequestBody  Channel channel,@RequestBody  Message message) {
		messageService.save(message, channel);

		Message findByMessageId = messageService.findByMessageId(message.getMessageId());
		if (message.getChannel() != null) {
			// model.put("message", findByMessageId.getMessageContent());
		}
		return "redirect:/channels/" + message.getChannel().getChannelId();
	}
}
