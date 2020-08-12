package com.pricing.pricingengine;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest
@AutoConfigureMockMvc
class PricingEngineApplicationTests {
	
	String exampleJson = "{\n" + 
			"    \"parts\" : [\n" + 
			"                {\n" + 
			"                    \"name\" : \"Tube\",\n" + 
			"                    \"count\" : 4\n" + 
			"                },\n" + 
			"                {\n" + 
			"                    \"name\" : \"Gears\",\n" + 
			"                    \"count\" : 4\n" + 
			"                },\n" + 
			"                {\n" + 
			"                    \"name\" : \"Tyre\",\n" + 
			"                    \"count\" : 2\n" + 
			"                }\n" + 
			"            ],\n" + 
			"    \"dateOfPricing\" : \"2020-10-01\"\n" + 
			"}";
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
    public void testCalculatePrice() throws Exception 
    {         
        RequestBuilder requestBuilder = MockMvcRequestBuilders
				.post("/calculatePrice")
				.accept(MediaType.APPLICATION_JSON).content(exampleJson)
				.contentType(MediaType.APPLICATION_JSON);
        
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        
        MockHttpServletResponse response = result.getResponse();

		assertEquals(HttpStatus.OK.value(), response.getStatus());
		
    }

}
