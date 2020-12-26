package com.jarvis.serviceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jarvis.model.Country;
import com.jarvis.repo.CountryRepository;
import com.jarvis.service.CountryService;

@Service
public class CountryServiceImpl implements CountryService {

	@Autowired
	private CountryRepository countryRepository;

	@Override
	public Map<Integer, String> findCountries() {

		List<Country> listOfCountries = countryRepository.findAll();
		Map<Integer, String> countries = new HashMap<>();
		listOfCountries.forEach(country -> {
			countries.put(country.getCountryId(), country.getCountryName());
		});
		return countries;
	}

}
