package com.iyzico.challenge.model.dto;

import java.math.BigDecimal;

public class ProductDTO {
	
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
		return "ProductDTO [id=" + id + ", name=" + name + ", description=" + description + ", remainingStockCount="
				+ remainingStockCount + ", price=" + price + "]";
	}
	
	
	
}
