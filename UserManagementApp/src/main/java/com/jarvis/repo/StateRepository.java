package com.jarvis.repo;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jarvis.model.Country;
import com.jarvis.model.State;

public interface StateRepository extends JpaRepository<State, Serializable> {
	
	
	List<State> findByCountryId(Integer countryId);

}
