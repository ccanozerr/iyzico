package com.iyzico.challenge.model.dto;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;

import org.junit.Test;

public class ProductDTOTest {

	@Test
	public void it_should_convert_to_string_properly() {

		ProductDTO dto = new ProductDTO();
		dto.setId(1L);
		dto.setName("name");
		dto.setDescription("description");
		dto.setPrice(new BigDecimal(1995));
		dto.setRemainingStockCount(1000L);

		String dtoStringValue = dto.toString();

		assertThat(dtoStringValue).isEqualTo("ProductDTO [id=1, name=name, description=description, remainingStockCount=1000, price=1995]");
	}

}
