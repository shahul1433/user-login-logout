package com.spring.loginlogout.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserRestController {

	@Autowired
	UserRepository userRepository;
	
	@RequestMapping(value="/get-users", method=RequestMethod.GET)
	public List<TUser> getUsers() {
		List<TUser> list = userRepository.findAll();
		return list;
	}
	
	@RequestMapping(value="/signup", method=RequestMethod.POST)
	public void signup(TUser user) {
		userRepository.save(user);
	}
}
