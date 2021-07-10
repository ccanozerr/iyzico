
package com.iyzico.challenge.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iyzico.challenge.entity.Product;
import com.iyzico.challenge.model.dto.ProductDTO;
import com.iyzico.challenge.model.request.ProductCreateRequest;
import com.iyzico.challenge.model.request.ProductUpdateRequest;
import com.iyzico.challenge.repository.ProductRepository;

@Service
@Transactional
public class ProductService {

	private Logger logger = LoggerFactory.getLogger(ProductService.class);

	private ProductRepository productRepository;

	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	public ProductDTO createProduct(ProductCreateRequest request) {

		Product product = new Product();
		product.setName(request.getName());
		product.setDescription(request.getDescription());
		product.setPrice(request.getPrice());
		product.setRemainingStockCount(request.getRemainingStockCount());

		productRepository.save(product);

		logger.info("Product saved successfully! {}", product);

		return product.toDTO(product);
	}

	public ProductDTO updateProduct(ProductUpdateRequest request) {

		Product product = productRepository.getOne(request.getId());
		product.setName(request.getName());
		product.setDescription(request.getDescription());
		product.setPrice(request.getPrice());
		product.setRemainingStockCount(request.getRemainingStockCount());

		productRepository.save(product);

		logger.info("Product updated successfully! {}", product);

		return product.toDTO(product);
	}

	public boolean deleteProduct(Long id) {

		Product product = productRepository.getOne(id);
		
		productRepository.delete(product);

		logger.info("Product deleted successfully!");

		return true;
	}

	public List<ProductDTO> getProductList() {
		
		List<Product> products = productRepository.findAll();
		
		List<ProductDTO> productDTOs = new ArrayList<>();
		
		products.stream().forEach(p -> {
			productDTOs.add(p.toDTO(p));
		});
		
		logger.info("Products getting successfully!");
		
		return productDTOs;
	}
	
	public boolean isProductStockEnabled(Long id, Long soldStock) {
		
		Product product = productRepository.getOne(id);
		
		return soldStock <= product.getRemainingStockCount() ? true: false;
		
	}

}
