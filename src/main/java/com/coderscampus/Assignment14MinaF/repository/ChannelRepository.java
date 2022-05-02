package com.coderscampus.Assignment14MinaF.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coderscampus.Assignment14MinaF.domain.Channel;

@Repository
public interface ChannelRepository extends JpaRepository<Channel, Long> {

	List<Channel> findAll();

}
