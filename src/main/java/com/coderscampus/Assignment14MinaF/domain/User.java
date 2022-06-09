package com.coderscampus.Assignment14MinaF.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {

	

	private Long userId;
	private String userName;
	private List<Channel> channels;
	private List<Message> messages = new ArrayList<Message>();

	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	public List<Message> getMessages() {
		return messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getUserId() {
		return userId;
	}

	@ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
	@JoinTable(name = "user_channels", 
	joinColumns = @JoinColumn(name = "user_id"), 
	inverseJoinColumns = @JoinColumn(name = "channel_id"))
	public List<Channel> getChannels() {
		return channels;
	}

	public void setChannels(List<Channel> channels) {
		this.channels = channels;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}
