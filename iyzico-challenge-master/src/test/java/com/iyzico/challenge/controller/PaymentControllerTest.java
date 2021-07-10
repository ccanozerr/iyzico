package com.iyzico.challenge.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.iyzico.challenge.entity.Product;
import com.iyzico.challenge.model.request.ProductPayRequest;
import com.iyzico.challenge.repository.ProductRepository;
import com.iyzico.challenge.service.IyzicoPaymentService;
import com.iyzico.challenge.service.ProductService;

@RunWith(MockitoJUnitRunner.class)
public class PaymentControllerTest {

	private MockMvc mockMvc;
	
	@InjectMocks
	private PaymentController paymentController;

	@Mock
	private ProductService productService;

	@Mock
	private IyzicoPaymentService paymentService;
	
	@Mock
	private ProductRepository productRepository;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(paymentController).build();
	}

	@Test
	public void it_should_invoke_api_payment_endpoint() throws Exception {
		
		ProductPayRequest request = new ProductPayRequest();
		request.setPrice(new BigDecimal(1000));
		request.setProductId(1L);
		request.setSoldStock(100L);
		
		Product product = new Product();
		product.setId(1L);
		product.setRemainingStockCount(1001L);
		
		ObjectWriter objectWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String requestBody = objectWriter.writeValueAsString(request);
        
        Mockito.when(productRepository.getOne(product.getId())).thenReturn(product);
        Mockito.when(productService.isProductStockEnabled(Mockito.any(), Mockito.any())).thenReturn(true);
        
        mockMvc.perform(post("/api/payment")
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(requestBody))
                .andExpect(status().isBadRequest())
                .andReturn();

	}

}
