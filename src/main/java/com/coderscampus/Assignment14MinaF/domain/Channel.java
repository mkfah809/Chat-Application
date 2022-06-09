package com.coderscampus.Assignment14MinaF.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "channels")
public class Channel {
	

	private Long channelId;
	private String channelName;
	private List<Message> messages = new ArrayList<Message>();
	private List<User> users = new ArrayList<User>();
	
	@ManyToMany(mappedBy = "channels"
			,fetch = FetchType.LAZY)
	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getChannelId() {
		return channelId;
	}

	@OneToMany(mappedBy = "channel"
			  ,fetch = FetchType.LAZY)
	public List<Message> getMessages() {
		return messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}

	public void setChannelId(Long channelId) {
		this.channelId = channelId;
	}

	public String getChannelName() {
		return channelName;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}



}
