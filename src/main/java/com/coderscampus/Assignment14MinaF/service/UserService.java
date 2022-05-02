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
			setChannelToExistingUser(user, new Channel());

		} else {

			System.out.println("User is NEW");

		}
		return userRepo.save(user);
	}

	private Channel setChannelToExistingUser(User user, Channel channel) {
		channel = channelService.createChannel(user);
		findById(user.getUserId());
		System.out.println(channel.getChannelId());
		Channel findByChannelId = channelService.findById(channel.getChannelId());
		ArrayList<User> users = new ArrayList<>();
		ArrayList<Channel> channels = new ArrayList<>();
		users.add(user);
		channel.setUsers(users);
		channels.add(channel);
		user.setChannels(channels);
		return findByChannelId;
	}

	public User findById(Long userId) {
		Optional<User> userOpt = userRepo.findById(userId);
		return userOpt.orElse(new User());
	}

	public User createNewUser(User user) {
		return userRepo.save(user);
	}

}
