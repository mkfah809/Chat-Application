package com.coderscampus.Assignment14MinaF.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coderscampus.Assignment14MinaF.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	public User findByuserName(String userName);
}
