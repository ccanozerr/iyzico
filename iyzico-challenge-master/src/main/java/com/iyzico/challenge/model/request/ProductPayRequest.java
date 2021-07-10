package com.iyzico.challenge.model.request;

import java.math.BigDecimal;

public class ProductPayRequest {
	
	private BigDecimal price;
	private Long soldStock;
	private Long productId;
	
	public BigDecimal getPrice() {
		return price;
	}
	
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
	public Long getSoldStock() {
		return soldStock;
	}
	
	public void setSoldStock(Long soldStock) {
		this.soldStock = soldStock;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}
	
}
