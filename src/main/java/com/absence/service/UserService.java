package com.absence.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.absence.entity.User;
import com.absence.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public User getUserByUsername(String username) {
		return userRepository.findByUsername(username);
	}

	public User loginUser(User user) {
		
		
		User dbUser = userRepository.findByUsername(user.getUsername());
		System.out.println(user);
		System.out.println(dbUser);

		if (user.equals(dbUser)) {
			
			return dbUser;
		}
		
		return null;
	}
	
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	public User getUserById(Long id) {
		return userRepository.getOne(id);
	}

	public User saveOrUpdateUser(User user) {
		return userRepository.save(user);
	}

	public void deleteUser(Long id) {
		userRepository.deleteById(id);
	}

}
