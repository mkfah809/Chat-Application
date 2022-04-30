package com.coderscampus.Assignment14MinaF.service;

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

	public User saveUser(User user) {
	
		if (user.getUserId() != null) {
			
		} else {
			
		}
		return userRepo.save(user);
	}

	public User findById(Long userId) {
		Optional<User> userOpt = userRepo.findById(userId);
		System.out.println("userId"  + userId);
		return userOpt.orElse(null);
	}

}
