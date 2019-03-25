package com.spring.loginlogout.user;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@GetMapping("/signup")
	public String signupForm(TUser user) {
		return "signup/index";
	}
	
	@PostMapping("/signup")
	public String result(@Valid TUser user, BindingResult bindingResult) {
		
		if(bindingResult.hasErrors()) {
			return "signup/index";
		}
		//Encrypt Password before save.
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		
		userService.save(user);
		System.out.println("User registered successfully");
		return "redirect:/home";
	}
	
	@GetMapping("/")
	public String getHome(ModelMap model) {
		List<TUser> users = new ArrayList<>();
		TUser user = new TUser("Shahul", "shahul1433", "apple");
		users.add(user);
		model.addAttribute("users", users);
		return "home/index";
	}
}
