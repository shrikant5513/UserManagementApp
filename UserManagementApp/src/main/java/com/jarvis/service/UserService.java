package com.jarvis.service;

import java.util.Map;

import com.jarvis.model.User;

public interface UserService {

	  String loginCheck(String email, String password);
	  
	  boolean isEmailUnique(String emailId);
	  
	  boolean saveUser(User user);
	  
	  boolean isTempPwdValid(String email, String tempPwd );
	  
	  boolean unlockAccount(String email, String newPwd);
	  
	  String forgetPassword(String email);
	  
	  
	  
	  
	
}
