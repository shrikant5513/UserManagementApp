package com.jarvis.restController;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jarvis.model.City;
import com.jarvis.model.Country;
import com.jarvis.model.State;
import com.jarvis.model.User;
import com.jarvis.service.CityService;
import com.jarvis.service.CountryService;
import com.jarvis.service.StateService;
import com.jarvis.service.UserService;

@RestController
@RequestMapping("users")
public class UserRegistrationRestController {

	@Autowired
	private UserService userService;

	@Autowired
	private CountryService countryService;

	@Autowired
	private StateService stateService;

	@Autowired
	private CityService cityService;


	@GetMapping("/unique/{email}")
	public ResponseEntity<String> isEmailUnique(@PathVariable String email) {
		// TODO
		userService.isEmailUnique(email);
		return null;
	}

	@GetMapping("/allCountry")
	public ResponseEntity<List<Country>> getAllCountries() {
		// TODO
		Map<Integer, String> countries = countryService.findCountries();
		return null;
	}

	@GetMapping("/allStates/{countryId}")
	public ResponseEntity<List<State>> getStates(@PathVariable Integer countryId) {
		// TODO
		stateService.findStates(countryId);
		return null;
	}

	@GetMapping("/allCities/{stateId}")
	public ResponseEntity<List<City>> getCities(@PathVariable Integer stateId) {
		// TODO
		cityService.findCities(stateId);   
		return null;
	}

	@PostMapping("/register")
	public ResponseEntity<String> saveUser(@RequestBody User user) {
		// TODO
		userService.saveUser(user);
		return null;
	}

	@GetMapping("/{email}")
	public ResponseEntity<String> handleForgetPassword(@PathVariable String email) {
		// TODO
		userService.forgetPassword(email);
		return null;
	}

}
