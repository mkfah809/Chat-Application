package com.coderscampus.Assignment14MinaF.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

		if (user.getUserId() == null) {
			setUserToExistingChannel(user, new Channel(), new ArrayList<>(), new ArrayList<>());

		} else {

			System.out.println("UserExists");

		}
		return userRepo.save(user);
	}

	private void setUserToExistingChannel(User user, Channel channel, List<User> users, List<Channel> channels) {
		channels = channelService.findAllChannels();
		if (channels.isEmpty()) {
			channel.setChannelName("general");
			channels.add(channel);
			channelRepo.save(channel);
		}
		connectParentToChild(user, channel, users, channels);
	}

	private void connectParentToChild(User user, Channel channel, List<User> users, List<Channel> channels) {
		users.add(user);
		channel.setUsers(users);
		user.setChannels(channels);
	}

	public User findByUserId(Long userId) {
		Optional<User> userOpt = userRepo.findById(userId);
		System.out.println("The userId I get is " + userId);
		return userOpt.orElse(null);

	}

}
