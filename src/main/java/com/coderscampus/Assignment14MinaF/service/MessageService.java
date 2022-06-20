package com.coderscampus.Assignment14MinaF.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coderscampus.Assignment14MinaF.domain.Channel;
import com.coderscampus.Assignment14MinaF.domain.Message;

import com.coderscampus.Assignment14MinaF.repository.MessageRepository;

@Service
public class MessageService {

	@Autowired
	MessageRepository messageRepo;
	@Autowired
	ChannelService channelService;
	@Autowired
	UserService userService;

	public Message saveMessage(Message message) {
		Long channelId = null;
		Channel channel = channelService.findByChannelId(channelId);
		message.setChannel(channel);
		channel.setMessages(new ArrayList<Message>());
		new ArrayList<Message>().add(message);
		new ArrayList<Channel>().add(channel);
		message.setUser(userService.findByUserId(message.getUser().getUserId()));
		userService.findByUserId(message.getUser().getUserId()).setMessages(new ArrayList<Message>());
		new ArrayList<Message>().add(message);

		return messageRepo.save(message);
	}

	public List<Message> findAllMessages() {
		return messageRepo.findAll();
	}

	public Message findByMessageId(Long MessageId) {
		return messageRepo.findById(MessageId).orElse(null);
	}
}
