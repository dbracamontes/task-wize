package com.dbracamo.task.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.dbracamo.task.entity.States;
import com.dbracamo.task.repository.StateRepository;

@RestController
public class StateController<State> {
 
	@Autowired
	private StateRepository stateRep;
	
	@GetMapping(value="/states", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<States> getAllStates() {
		List<States> states = stateRep.findAll();
		return states;
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/state/{id}")
	@ResponseBody
	public ResponseEntity<States> getStateById(@PathVariable("id") Long id) {
		Optional<States> state = stateRep.findById(id);
		if(state.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(state.get());
		}
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/state")
	@ResponseBody
	public ResponseEntity<States> getStateById(@RequestParam("name") String name) {
		Optional<States> state = stateRep.findByName(name);
		if(state.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(state.get());
		}
	}
}
