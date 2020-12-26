package com.jarvis.serviceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jarvis.model.State;
import com.jarvis.repo.StateRepository;
import com.jarvis.service.StateService;

@Service
public class StateServiceImpl implements StateService {

	@Autowired
	private StateRepository stateRepository;

	@Override
	public Map<Integer, String> findStates(Integer countryId) {

		List<State> stateList = stateRepository.findByCountryId(countryId);
		Map<Integer, String> states = new HashMap<Integer, String>();
		stateList.forEach(state -> {
			states.put(state.getStateId(), state.getStateName());
		});
		return states;
	}

}
