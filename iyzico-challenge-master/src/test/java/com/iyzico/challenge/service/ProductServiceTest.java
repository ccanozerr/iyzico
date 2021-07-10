package com.iyzico.challenge.service;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import com.iyzico.challenge.model.request.ProductCreateRequest;
import com.iyzico.challenge.repository.ProductRepository;

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceTest {
	
	@InjectMocks
	ProductService productService;
	
	@Mock
	ProductRepository productRepository;
	
	@Test
	public void it_should_save_product() {
		
		ProductCreateRequest request = new ProductCreateRequest();
		request.setName("name");
		request.setDescription("description");
		request.setPrice(new BigDecimal(1995));
		request.setRemainingStockCount(1000L);
		
		productService.createProduct(request);
	}

}
