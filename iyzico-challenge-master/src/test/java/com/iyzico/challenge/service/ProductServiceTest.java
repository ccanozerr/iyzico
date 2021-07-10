package com.iyzico.challenge.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.iyzico.challenge.entity.Product;
import com.iyzico.challenge.model.dto.ProductDTO;
import com.iyzico.challenge.model.request.ProductCreateRequest;
import com.iyzico.challenge.model.request.ProductUpdateRequest;
import com.iyzico.challenge.repository.ProductRepository;

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceTest {
	
	@InjectMocks
	private ProductService productService;
	
	@Mock
	private ProductRepository productRepository;
	
	@Test
	public void it_should_save_product() {
		
		ProductCreateRequest request = new ProductCreateRequest();
		request.setName("name");
		request.setDescription("description");
		request.setPrice(new BigDecimal(1995));
		request.setRemainingStockCount(1000L);
		
		productService.createProduct(request);
	}
	
	@Test
	public void it_should_update_product() {
		
		Product product = new Product();
		product.setId(1L);
		
		Mockito.when(productRepository.getOne(product.getId())).thenReturn(product);
		
		ProductUpdateRequest request = new ProductUpdateRequest();
		request.setId(1L);
		request.setName("name");
		request.setDescription("description");
		request.setPrice(new BigDecimal(1995));
		request.setRemainingStockCount(1000L);
		
		productService.updateProduct(request);
	}
	
	@Test
	public void it_should_delete_product() {
		
		Product product = new Product();
		product.setId(1L);
		
		Mockito.when(productRepository.getOne(product.getId())).thenReturn(product);
		
		productService.deleteProduct(product.getId());
	}
	
	@Test
	public void it_should_return_product_list() {
		
		List<Product> products = new ArrayList<>();
		
		Product product1 = new Product();
		product1.setId(1L);
		product1.setName("name");
		product1.setDescription("description");
		product1.setPrice(new BigDecimal(1995));
		product1.setRemainingStockCount(1000L);
		
		Product product2 = new Product();
		product2.setId(1L);
		product2.setName("name");
		product2.setDescription("description");
		product2.setPrice(new BigDecimal(1995));
		product2.setRemainingStockCount(1000L);
		
		products.add(product1);
		products.add(product2);
		
		Mockito.when(productRepository.findAll()).thenReturn(products);
		
		List<ProductDTO> dtos = productService.getProductList();
		
		assertEquals(2, dtos.size());
		
	}
	
	@Test
	public void it_should_return_is_stock_enabled() {
		
		Product product = new Product();
		product.setId(1L);
		product.setRemainingStockCount(1001L);
		
		Mockito.when(productRepository.getOne(product.getId())).thenReturn(product);
		
		boolean isStockEnabled = productService.isProductStockEnabled(1L, 100L);
		
		assertEquals(true, isStockEnabled);
		
	}

}
