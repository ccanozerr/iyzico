package com.iyzico.challenge.model.request;

import java.math.BigDecimal;

public class ProductCreateRequest {
	
	private String name;
	private String description;
	private Long remainingStockCount;
	private BigDecimal price;
	
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
		return "ProductCreateRequest [name=" + name + ", description=" + description + ", remainingStockCount="
				+ remainingStockCount + ", price=" + price + "]";
	}
	
}
