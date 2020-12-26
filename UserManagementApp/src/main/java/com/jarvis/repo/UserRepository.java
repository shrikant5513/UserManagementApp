package com.jarvis.repo;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jarvis.model.User;

public interface UserRepository extends  JpaRepository<User, Serializable>{
	
	User findByEmailAndPassword(String email, String password);
	
	User findByEmail(String emailId);

}
