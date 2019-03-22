package com.spring.loginlogout.user;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<TUser, Long>{
	public TUser findByUsername(String username);
}
