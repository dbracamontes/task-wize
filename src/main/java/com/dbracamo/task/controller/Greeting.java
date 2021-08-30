package com.dbracamo.task.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Greeting {
	
	@GetMapping(value = "greeting")
	public String greting() {
		return "Hello world";
	}

}
