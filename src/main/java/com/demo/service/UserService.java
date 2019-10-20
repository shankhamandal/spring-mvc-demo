package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.UserRepository;
import com.demo.model.User;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public User findUserByUserName(String username) {

		return userRepository.findByUsername(username);
	}

	public void saveUser(User user) {
		userRepository.save(user);
	}

	public void deleteUser(User user) {
		userRepository.delete(user);
	}

	public void deleteAllUsers() {
		userRepository.deleteAll();
	}

	public List<User> findAllUsers() {
		return userRepository.findAll();
	}

}
