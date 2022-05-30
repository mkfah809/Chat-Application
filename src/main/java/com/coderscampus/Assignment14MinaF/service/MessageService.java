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

	public Message save(Message message, Long channelId, User user) {
		setMessagesToChannelAndUser(message, channelService.findByChannelId(channelId), new ArrayList<>(), user);
		return messageRepo.save(message);
	}

	private void setMessagesToChannelAndUser(Message message, Channel channel, List<Message> messages, User user) {
		List<User> users = channel.getUsers();
//		System.out.println(user.getUserId());
		message.setUser(user);
		user.setMessages(messages);
		message.setChannel(channel);
		channel.setMessages(messages);
		messages.add(message);

	}

	public List<Message> findAllMessages() {
		return messageRepo.findAll();
	}

	public Message findByChannelId(Long MessageId) {
		return messageRepo.findById(MessageId).orElse(null);
	}
}
