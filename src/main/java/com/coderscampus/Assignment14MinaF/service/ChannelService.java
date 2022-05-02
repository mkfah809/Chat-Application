package com.coderscampus.Assignment14MinaF.service;


import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coderscampus.Assignment14MinaF.domain.Channel;
import com.coderscampus.Assignment14MinaF.domain.User;
import com.coderscampus.Assignment14MinaF.repository.ChannelRepository;

@Service
public class ChannelService {
	@Autowired
	ChannelRepository channelRepo;

	public Channel createChannel (User user) {
		Channel channel = new Channel ();
		channel.setChannelName("general");
		return channelRepo.save(channel);
	}
	
	public Channel findById(Long channelId) {
		Optional<Channel> channelOpt = channelRepo.findById(channelId);
		System.out.println("Channel ID XXX " + channelId);
		return channelOpt.orElse(null);
	}
	
	public List<Channel> findAllChannels() {
		List<Channel> findAll = channelRepo.findAll();
		Channel next = findAll.iterator().next();
		System.out.println("XXX " + next.getChannelName());
		return findAll;
	
	}

	
}
