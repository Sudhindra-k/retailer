package com.retailer.contollerTests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

//Controller Test Cases
@AutoConfigureMockMvc
@SpringBootTest
public class RetailerControllerTests {
	
	private MockMvc mockmvc;

	@Autowired
	private WebApplicationContext context;
	
	@BeforeEach
	public void setup() {
		mockmvc = MockMvcBuilders.webAppContextSetup(context).apply(springSecurity()).build();
	}
	
	@WithMockUser(username="test" , authorities = "ADMIN")
	@Test
	@DisplayName("Valid Input")
	public void validTest() throws Exception{
		MvcResult result = mockmvc.perform(get("/list").contentType(MediaType.APPLICATION_JSON))
								  .andExpect(status().isOk()).andReturn();
		
		assertEquals(200, result.getResponse().getStatus());
	}
	
	
	@WithMockUser(username="test")
	@Test
	@DisplayName("Without passing authority")
	public void noauthority() throws Exception{
		MvcResult result = mockmvc.perform(get("/list").contentType(MediaType.APPLICATION_JSON))
								  .andExpect(status().isForbidden()).andReturn();
		
		assertEquals(403, result.getResponse().getStatus());
	}
	
	
	@WithMockUser(username="tes" , authorities = "AMIN")
	@Test
	@DisplayName("InValid Input")
	public void invalidinputs() throws Exception{
		MvcResult result = mockmvc.perform(get("/list").contentType(MediaType.APPLICATION_JSON))
								  .andExpect(status().isForbidden()).andReturn();
		
		assertEquals(403, result.getResponse().getStatus());
	}
	
	@Test
	@DisplayName("Not passnig any details")
	public void nodetails() throws Exception{
		MvcResult result = mockmvc.perform(get("/list").contentType(MediaType.APPLICATION_JSON))
								  .andExpect(status().isFound()).andReturn();
		
		assertEquals(302, result.getResponse().getStatus());
		
	}
	
	
	@Test
	@DisplayName("Invalid Mapping")
	public void invalidmapping() throws Exception{
		MvcResult result = mockmvc.perform(get("/lists").contentType(MediaType.APPLICATION_JSON))
								  .andExpect(status().isNotFound()).andReturn();
		
		assertEquals(404, result.getResponse().getStatus());
		
	}

	
	@WithMockUser(username="test" , authorities = "ADMIN")
	@Test
	@DisplayName("Order with Passing Id")
	public void orderwithId() throws Exception{
		MvcResult result = mockmvc.perform(get("/order?id=1").contentType(MediaType.APPLICATION_JSON))
								  .andExpect(status().isOk()).andReturn();
		
		assertEquals(200, result.getResponse().getStatus());
	}
	
	@WithMockUser(username="test" , authorities = "ADMIN")
	@Test
	@DisplayName("Order without Passing value")
	public void orderwithoutId() throws Exception{
		MvcResult result = mockmvc.perform(get("/order").contentType(MediaType.APPLICATION_JSON_VALUE))
								  .andExpect(status().isBadRequest()).andReturn();
		
		assertEquals(400, result.getResponse().getStatus());
	}
}
