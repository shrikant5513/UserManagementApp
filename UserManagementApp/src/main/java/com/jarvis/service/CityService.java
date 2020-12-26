package com.jarvis.service;

import java.util.Map;

public interface CityService {
	
	Map<Integer, String> findCities(Integer stateId);

}
