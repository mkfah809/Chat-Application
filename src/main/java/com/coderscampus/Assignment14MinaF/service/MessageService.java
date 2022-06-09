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

		setMessagesToChannelAndUser(message, message.getChannel(), new ArrayList<>());
		return messageRepo.save(message);
	}

	private void setMessagesToChannelAndUser(Message message, Channel channel, List<Message> messages) {

		message.setChannel(channel);
		messages.add(message);
		channel.setMessages(messages);
//		message.setUser();
//		saveUser.setMessages(messages);
		messages.add(message);
	}

	public List<Message> findAllMessages() {
		return messageRepo.findAll();
	}

	public Message findByChannelId(Long MessageId) {
		return messageRepo.findById(MessageId).orElse(null);
	}
}
