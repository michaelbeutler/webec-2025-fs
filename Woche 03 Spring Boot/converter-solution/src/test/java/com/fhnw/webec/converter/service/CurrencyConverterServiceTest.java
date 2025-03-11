package com.fhnw.webec.converter.service;

import com.fhnw.webec.converter.data.Currency;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CurrencyConverterServiceTest {

	@Test
	public void convertDifferentCurrencies() {
		var service = new CurrencyConverterService();

		var result = service.convert(Currency.GBP, Currency.CHF, 100d);

		assertEquals(113.64, result);
	}

	@Test
	public void convertSameCurrency() {
		var service = new CurrencyConverterService();

		var result = service.convert(Currency.CHF, Currency.CHF, 100d);

		assertEquals(100d, result);
	}
}
