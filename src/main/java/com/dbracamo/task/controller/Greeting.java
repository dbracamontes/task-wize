package com.dbracamo.task.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Greeting {
	
	@GetMapping(value = "greeting", produces = MediaType.APPLICATION_JSON_VALUE)
	public String greting() {
		return "Hello world";
	}

}
