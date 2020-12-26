package com.jarvis.serviceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jarvis.model.City;
import com.jarvis.repo.CityRepository;
import com.jarvis.service.CityService;

@Service
public class CityServiceImpl implements CityService {

	@Autowired
	private CityRepository cityRepository;

	@Override
	public Map<Integer, String> findCities(Integer stateId) {

		List<City> citiesList = cityRepository.findByStateId(stateId);
		Map<Integer, String> cities = new HashMap<Integer, String>();
		citiesList.forEach(city -> {
			cities.put(city.getCityId(), city.getCityName());
		});
		return cities;
	}

}
