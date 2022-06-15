package com.coderscampus.Assignment14MinaF.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coderscampus.Assignment14MinaF.domain.Channel;
import com.coderscampus.Assignment14MinaF.domain.User;
import com.coderscampus.Assignment14MinaF.repository.ChannelRepository;
import com.coderscampus.Assignment14MinaF.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository userRepo;
	@Autowired
	ChannelRepository channelRepo;
	@Autowired
	ChannelService channelService;

	public User saveUser(User user) {

		setChannelToUser(user, channelService.findAllChannels(), new Channel());
		return userRepo.save(user);

	}

	private void setChannelToUser(User user, List<Channel> channels, Channel channel) {
		if (channels.isEmpty()) {
			channel.setChannelName("general");
			channels.add(channel);
			channelRepo.save(channel);
		}
		ArrayList<User> users = new ArrayList<>();
		users.add(user);
		channel.setUsers(users);
		user.setChannels(channels);
	}

	public User findByUserId(Long userId) {
		return userRepo.findById(userId).orElse(null);
	}

	public List<User> findAll() {
		return userRepo.findAll();
	}

	public void deleteByUserId(User user) {
		userRepo.delete(user);
		
	}
}
