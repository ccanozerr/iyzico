package com.iyzico.challenge.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.iyzico.challenge.model.request.ProductPayRequest;
import com.iyzico.challenge.service.IyzicoPaymentService;
import com.iyzico.challenge.service.ProductService;

@WebMvcTest(PaymentController.class)
public class PaymentControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private ProductService productService;

	@MockBean
	private IyzicoPaymentService paymentService;

	@Test
	public void it_should_invoke_api_payment_endpoint() throws Exception {
		
		ProductPayRequest request = new ProductPayRequest();
		request.setPrice(new BigDecimal(1000));
		request.setProductId(1L);
		request.setSoldStock(100L);
		
		ObjectWriter objectWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String requestBody = objectWriter.writeValueAsString(request);
        
        mockMvc.perform(post("/api/payment")
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(requestBody))
                .andExpect(status().isOk())
                .andReturn();

	}

}
