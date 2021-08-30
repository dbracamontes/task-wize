package com.dbracamo.task;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.dbracamo.task.controller.Greeting;

@WebMvcTest(controllers = {Greeting.class})
public class GreetingTest {

	@Autowired private MockMvc mvc;
	
	@Test
	void getGreeting() throws Exception {
		final ResultActions result =
			      mvc.perform(
			              get("/greeting")
			                  .contentType(MediaType.APPLICATION_JSON));
			
			result
			    .andExpect(status().isOk())
			    .andExpect(content()
			            .contentType(MediaType.APPLICATION_JSON))
			    .andExpect(content().string(containsString("Hello world")));
	}

}
