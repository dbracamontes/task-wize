package com.dbracamo.task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.dbracamo.task.entity.States;

import  static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class StateControllerTest {
	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void getAll() throws Exception {		
		ResponseEntity<States[]> response =
				  restTemplate.getForEntity(
				  "http://localhost:"+ port + "/states/",
				  States[].class);
		States[] states = response.getBody();
		
		assertEquals(response.getStatusCode(), HttpStatus.OK);
		assertEquals(states.length, 2);
		assertEquals(states[0].getName(),"Aguascalientes");
		assertEquals(states[0].getId(), 1);
		assertEquals(states[1].getName(), "Jalisco");
		assertEquals(states[1].getId(), 2);
	}
	
	@Test
	public void getStateById() throws Exception {		
		ResponseEntity<States> response =
				  restTemplate.getForEntity(
				  "http://localhost:"+ port + "/state/1",
				  States.class);
		States state = response.getBody();
		
		assertEquals(response.getStatusCode(),HttpStatus.OK);
		assertEquals(state.getId(), 1);
		assertEquals(state.getName(),"Aguascalientes");
	}
	
	@Test
	public void getStateByIdNotFound() throws Exception {		
		ResponseEntity<States> response =
				  restTemplate.getForEntity(
				  "http://localhost:"+ port + "/state/4",
				  States.class);

		assertEquals(response.getStatusCode(), HttpStatus.NOT_FOUND);
	}
	
	@Test
	public void getStateByName() throws Exception {		
		ResponseEntity<States> response =
				  restTemplate.getForEntity(
				  "http://localhost:"+ port + "/state?name=Jalisco",
				  States.class);
		States state = response.getBody();
		
		assertEquals(response.getStatusCode(),HttpStatus.OK);
		assertEquals(state.getId(), 2);
		assertEquals(state.getName(),"Jalisco");
	}
	
	@Test
	public void getStateByNameNotFound() throws Exception {		
		ResponseEntity<States> response =
				  restTemplate.getForEntity(
				  "http://localhost:"+ port + "/state?name=Test",
				  States.class);
		
		assertEquals(response.getStatusCode(),HttpStatus.NOT_FOUND);
	}

}