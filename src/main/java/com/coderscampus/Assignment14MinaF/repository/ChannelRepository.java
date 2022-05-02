package com.coderscampus.Assignment14MinaF.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.coderscampus.Assignment14MinaF.domain.Channel;

@Repository
public interface ChannelRepository extends JpaRepository<Channel, Long>{
//	@Query("select c.channel_name, u.user_name\r\n"
//			+ "from channels c , users u, user_channels  uc\r\n"
//			+ "where c.channel_id = uc.channel_id\r\n"
//			+ "and  u.user_id = uc.user_id;")
//	Set<Channel> findAllChannelsWithUsers();
	

}
