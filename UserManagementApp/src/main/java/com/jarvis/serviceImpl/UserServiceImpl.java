package com.jarvis.serviceImpl;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jarvis.model.User;
import com.jarvis.repo.UserRepository;
import com.jarvis.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	/**
	 * test-case :Invalid email and pass => invalid credentials test case : valid
	 * email and pwd account is locked =>Account locked test case : valid email and
	 * pwd account is unlocked => login success
	 * 
	 */
	@Override
	public String loginCheck(String email, String password) {

		User userDetails = userRepository.findByEmailAndPassword(email, password);

		if (userDetails != null) {

			if (userDetails.getAccountStatus().equals("LOCKED")) {

				return "ACCOUNT_LOCKED";
			} else {

				return "LOGIN_SUCCESS";
			}
		} else {
			return "INVAID_CREDENTIALS";
		}
	}

	@Override
	public boolean isEmailUnique(String emailId) {
		User userDetails = userRepository.findByEmail(emailId);
		return userDetails.getUserId() == null;
	}

	@Override
	public boolean saveUser(User user) {

		user.setPassword(generatePassword());
		user.setAccountStatus("LOCKED");
		User savedUser = userRepository.save(user);

		return savedUser.getUserId() != null;
	}

	/**
	 * test case : user has given invalid tempPwd ==> false test case : user has
	 * given valid tempPwd ==> true
	 * 
	 */
	@Override
	public boolean isTempPwdValid(String email, String tempPwd) {

		User userDetails = userRepository.findByEmailAndPassword(email, tempPwd);
		return userDetails.getUserId() != null;
	}

	@Override
	public boolean unlockAccount(String email, String newPwd) {

		User userDetails = userRepository.findByEmail(email);
		userDetails.setPassword(newPwd);
		userDetails.setAccountStatus("UNLOCKED");
		try {
			userRepository.save(userDetails);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * user entered valid email ==> return password user entered invalid email ==>
	 * return null
	 * 
	 */
	@Override
	public String forgetPassword(String email) {

		User userDetails = userRepository.findByEmail(email);
		if (userDetails != null) {
			return userDetails.getPassword();
		}
		return null;
	}

	public static String generatePassword() {
		/**
		 * password Length should be greater than 8 2,4,6,8 places only digits 1,3,5,7
		 * places only upper case alphabet and symbols @,#,$
		 */
		Supplier<String> s = () -> {

			String randomPwd = "";
			Supplier<Integer> d = () -> (int) Math.random() * 10;
			String symbols = "ABCDEFGHIJKLMNOPQRSTUVWXYZ#$@";
			Supplier<Character> c = () -> symbols.charAt((int) Math.random() * 29);
			for (int i = 1; i <= 8; i++) {
				if (i % 2 == 0) {
					randomPwd = randomPwd + d.get();
				} else {
					randomPwd = randomPwd + c.get();
				}
			}
			return randomPwd;
		};
		return s.get();
	}
}
