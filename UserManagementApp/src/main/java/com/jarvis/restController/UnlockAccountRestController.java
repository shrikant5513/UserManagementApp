package com.jarvis.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jarvis.service.UserService;

@RestController
@RequestMapping("/unlock")
public class UnlockAccountRestController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/signIn/{email}/{pwd}")
	public ResponseEntity<String> handleSignIn(@PathVariable String email, @PathVariable String pwd) {
		// TODO
		userService.loginCheck(email, pwd);
		return new ResponseEntity<String>(HttpStatus.OK);
	}
	
	
	@PatchMapping("{email}/{tempPwd}/{newPwd}") 
	public ResponseEntity<String> updatePassword(
			@PathVariable String email, 
			@PathVariable String tempPwd,
			@PathVariable String newPwd
			) 
	{
		// TODO
		userService.unlockAccount(email, newPwd);
		return null;
	}
	
}
