package com.absence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.absence.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	User findByUsername(String username);
	
}
