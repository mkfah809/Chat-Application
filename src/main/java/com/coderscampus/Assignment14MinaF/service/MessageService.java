package com.coderscampus.Assignment14MinaF.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coderscampus.Assignment14MinaF.domain.Channel;
import com.coderscampus.Assignment14MinaF.domain.Message;
import com.coderscampus.Assignment14MinaF.domain.User;
import com.coderscampus.Assignment14MinaF.repository.MessageRepository;

@Service
public class MessageService {

	@Autowired
	MessageRepository messageRepo;
	@Autowired
	ChannelService channelService;
	@Autowired
	UserService userService;

	public Message save(Message message, Channel channel) {
		channel = channelService.findByChannelId(channel.getChannelId());
		if (message.getMessageId() == null) {
			List<User> users = channel.getUsers();
			ArrayList<Message> messages = new ArrayList<>();
			
			User user = users.get(users.size()-1);
			user.setMessages(messages);
			messages.add(message);
			message.setUser(user);
			message.setChannel(channel);
			channel.setMessages(messages);
			messages.add(message);
			
		}
		System.out.println("message  is " + message.getMessageContent());

		return messageRepo.save(message);
	}
}
