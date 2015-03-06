package com.procurandoape.room;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;

public class RoomTest {

	@Test
	public void shouldFormatThePriceToBrazilWhenPriceIsHundred() throws Exception {
		PlaceToRental room = new PlaceToRental();
		room.setPrice(new BigDecimal("120"));

		assertEquals("R$ 120,00", room.getFormattedPrice());
	}

	@Test
	public void shouldFormatThePriceToBrazilWhenPriceIsThousand() throws Exception {
		PlaceToRental room = new PlaceToRental();
		room.setPrice(new BigDecimal("1500"));

		assertEquals("R$ 1.500,00", room.getFormattedPrice());
	}

	@Test
	public void shouldFormatThePriceToBrazilWhenPriceIsMoreThanTenThousand() throws Exception {
		PlaceToRental room = new PlaceToRental();
		room.setPrice(new BigDecimal("10500"));

		assertEquals("R$ 10.500,00", room.getFormattedPrice());
	}

}
