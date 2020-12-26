package com.jarvis.service;

import java.util.Map;

public interface StateService {

	Map<Integer, String> findStates(Integer countryId);
	
}
