package com.coderscampus.Assignment14MinaF.service;

import java.util.ArrayList;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coderscampus.Assignment14MinaF.domain.Channel;
import com.coderscampus.Assignment14MinaF.domain.User;

import com.coderscampus.Assignment14MinaF.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository userRepo;

	@Autowired
	ChannelService channelService;

	public User saveUser(User user) {

		if (user.getUserId() != null) {
			ArrayList<User> users = new ArrayList<>();
			ArrayList<Channel> channels = new ArrayList<>();
			setChannelToExistingUser(user, new Channel(), users, channels);
		} else {

			System.out.println("User is NEW");

		}
		return userRepo.save(user);
	}

	private Channel setChannelToExistingUser(User user, Channel channel, ArrayList<User> users,
			ArrayList<Channel> channels) {
		channel = channelService.createChannel(user);
		findById(user.getUserId());
		Channel findByChannelId = channelService.findById(channel.getChannelId());
		users.add(user);
		channel.setUsers(users);
		channels.add(channel);
		user.setChannels(channels);
		return findByChannelId;
	}

	public User findById(Long userId) {
		Optional<User> userOpt = userRepo.findById(userId);
		return userOpt.orElse(null);
	}

	public User createNewUser(User user) {
		return userRepo.save(user);
	}

	
	
	

}
