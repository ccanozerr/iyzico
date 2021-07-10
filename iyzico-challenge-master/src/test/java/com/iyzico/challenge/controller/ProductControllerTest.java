package com.iyzico.challenge.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.iyzico.challenge.model.request.ProductCreateRequest;
import com.iyzico.challenge.model.request.ProductUpdateRequest;
import com.iyzico.challenge.service.ProductService;

@RunWith(MockitoJUnitRunner.class)
public class ProductControllerTest {

	private MockMvc mockMvc;

	@InjectMocks
	private ProductController productController;

	@Mock
	private ProductService productService;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(productController).build();
	}

	@Test
	public void it_should_invoke_api_product_create_endpoint() throws Exception {

		ProductCreateRequest request = new ProductCreateRequest();

		ObjectWriter objectWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String requestBody = objectWriter.writeValueAsString(request);

		mockMvc.perform(post("/api/product").contentType(MediaType.APPLICATION_JSON_VALUE).content(requestBody))
				.andExpect(status().isOk()).andReturn();

	}

	@Test
	public void it_should_invoke_api_product_update_endpoint() throws Exception {

		ProductUpdateRequest request = new ProductUpdateRequest();

		ObjectWriter objectWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String requestBody = objectWriter.writeValueAsString(request);

		mockMvc.perform(put("/api/product").contentType(MediaType.APPLICATION_JSON_VALUE).content(requestBody))
				.andExpect(status().isOk()).andReturn();

	}

	@Test
	public void it_should_invoke_api_product_delete_endpoint() throws Exception {

		mockMvc.perform(delete("/api/product/1").contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk()).andReturn();
	}

	@Test
	public void it_should_invoke_api_product_get_endpoint() throws Exception {

		mockMvc.perform(get("/api/product").contentType(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isOk())
				.andReturn();

	}

}
