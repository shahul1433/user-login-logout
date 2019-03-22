package com.spring.loginlogout;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer{

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("home/index");
		registry.addViewController("/home").setViewName("home/index");
		registry.addViewController("/login").setViewName("login/index");
		registry.addViewController("/signup").setViewName("signup/index");
	}
}
