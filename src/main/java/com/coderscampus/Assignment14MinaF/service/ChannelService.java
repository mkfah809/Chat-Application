package com.coderscampus.Assignment14MinaF.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coderscampus.Assignment14MinaF.domain.Channel;
import com.coderscampus.Assignment14MinaF.domain.User;
import com.coderscampus.Assignment14MinaF.repository.ChannelRepository;
import com.coderscampus.Assignment14MinaF.repository.UserRepository;

@Service
public class ChannelService {
	@Autowired
	ChannelRepository channelRepo;
	
	public Channel createChannel (User user) {
		Channel channel = new Channel ();
		System.out.println("Channel is NEW");
		channel.setChannelName("general");
		return channelRepo.save(channel);
	}
	
	public Channel findById(Long channelId) {
		Optional<Channel> channelOpt = channelRepo.findById(channelId);
		return channelOpt.orElse(new Channel());
	}

	
}
