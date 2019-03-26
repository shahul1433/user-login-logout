package com.spring.loginlogout.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserRestController {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPassword;
	
	@RequestMapping(value="/get-users", method=RequestMethod.GET)
	public List<TUser> getUsers() {
		List<TUser> list = userRepository.findAll();
		return list;
	}
	
	@RequestMapping(value="/signup", method=RequestMethod.POST)
	public String signup(@RequestBody TUser user) {
		
		//Encrypt password before save;
		user.setPassword(bCryptPassword.encode(user.getPassword()));
		
		userRepository.save(user);
		
		return "User registered successfully";
	}
}
