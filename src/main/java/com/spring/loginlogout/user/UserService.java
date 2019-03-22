package com.spring.loginlogout.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public void save(TUser user) {
		userRepository.save(user);
	}
	
	public List<TUser> getAll() {
		List<TUser> users = userRepository.findAll();
		return users;
	}
}
