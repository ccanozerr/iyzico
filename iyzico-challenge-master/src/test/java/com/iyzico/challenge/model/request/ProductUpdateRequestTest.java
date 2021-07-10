package com.iyzico.challenge.model.request;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;

import org.junit.Test;

public class ProductUpdateRequestTest {
	
	@Test
	public void it_should_convert_to_string_properly() {

		ProductUpdateRequest request = new ProductUpdateRequest();
		request.setId(1L);
		request.setName("name");
		request.setDescription("description");
		request.setPrice(new BigDecimal(1995));
		request.setRemainingStockCount(1000L);

		String requestStringValue = request.toString();

		assertThat(requestStringValue).isEqualTo("ProductUpdateRequest [id=1, name=name, description=description, remainingStockCount=1000, price=1995]");
	}

}
