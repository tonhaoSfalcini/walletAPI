package com.wallet.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wallet.entities.User;
import com.wallet.respositories.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	public void save(User user) {
		userRepository.save(user);
	}
	
	public Optional<User> findByEmail(String email){
		return userRepository.findByEmailEquals(email);
	}
	
}
