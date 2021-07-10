package com.iyzico.challenge.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.iyzico.challenge.model.dto.ProductDTO;

@Entity
public class Product {
	
	@Id
    @GeneratedValue
    private Long id;
	private String name;
	private String description;
	private Long remainingStockCount;
	private BigDecimal price;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Long getRemainingStockCount() {
		return remainingStockCount;
	}
	
	public void setRemainingStockCount(Long remainingStockCount) {
		this.remainingStockCount = remainingStockCount;
	}
	
	public BigDecimal getPrice() {
		return price;
	}
	
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "Product [name=" + name + ", description=" + description + ", remainingStockCount=" + remainingStockCount
				+ ", price=" + price + "]";
	}
	
	public ProductDTO toDTO(Product product) {
		ProductDTO dto = new ProductDTO();
		dto.setId(product.getId());
		dto.setName(product.getName());
		dto.setDescription(product.getDescription());
		dto.setRemainingStockCount(product.getRemainingStockCount());
		dto.setPrice(product.getPrice());
		return dto;
	}
	
}
