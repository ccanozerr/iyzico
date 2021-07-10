package com.iyzico.challenge.model.request;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;

import org.junit.Test;

public class ProductCreateRequestTest {
	
	@Test
	public void it_should_convert_to_string_properly() {

		ProductCreateRequest request = new ProductCreateRequest();
		request.setName("name");
		request.setDescription("description");
		request.setPrice(new BigDecimal(1995));
		request.setRemainingStockCount(1000L);

		String requestStringValue = request.toString();

		assertThat(requestStringValue).isEqualTo("ProductCreateRequest [name=name, description=description, remainingStockCount=1000, price=1995]");
	}

}
