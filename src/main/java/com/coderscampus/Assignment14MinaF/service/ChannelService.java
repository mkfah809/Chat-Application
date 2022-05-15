package com.coderscampus.Assignment14MinaF.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coderscampus.Assignment14MinaF.domain.Channel;
import com.coderscampus.Assignment14MinaF.repository.ChannelRepository;

@Service	
public class ChannelService {
	@Autowired
	ChannelRepository channelRepo;

	public List<Channel> findAllChannels() {
		return channelRepo.findAll();
	}
	
	public Channel findByChannelId(Long channelId) {
		
		if(findAllChannels().size() == 1) {
			 channelId = findAllChannels().get(0).getChannelId();	
		}
		return channelRepo.findById(channelId).orElse(null);
	}

}
