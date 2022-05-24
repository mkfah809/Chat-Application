package com.coderscampus.Assignment14MinaF.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

	public Message save(Message message, Long channelId) {
		setMessagesToChannelAndUser(message, channelService.findByChannelId(channelId),new ArrayList<>());
		return messageRepo.save(message);
	}



	private void setMessagesToChannelAndUser(Message message, Channel channel, List<Message> messages) {
		List<User> users = channel.getUsers();		
		User user = users.get(users.size()-1);
		System.out.println(user.getUserName()+" XXX "+ user.getUserId());
		message.setChannel(channel);
		channel.setMessages(messages);
		
		user.setMessages(messages);
		message.setUser(user);
		
		messages.add(message);
		users.add(user);
		
	}

	public List<Message> findAllMessages() {
		return messageRepo.findAll();
	}

	public Message findByChannelId(Long MessageId) {
		return messageRepo.findById(MessageId).orElse(null);
	}
}
