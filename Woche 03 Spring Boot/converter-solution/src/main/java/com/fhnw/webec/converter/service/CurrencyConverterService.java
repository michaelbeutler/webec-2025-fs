package com.fhnw.webec.converter.service;

import com.fhnw.webec.converter.data.Currency;
import com.fhnw.webec.converter.data.ExchangeRate;
import org.springframework.stereotype.Service;

import java.util.*;

@Service // same as @Component
public class CurrencyConverterService {

	private List<ExchangeRate> exchangeRates = new LinkedList<ExchangeRate>();

	public CurrencyConverterService() {
		exchangeRates.add(new ExchangeRate(Currency.CHF, Currency.EUR, 1.06));
		exchangeRates.add(new ExchangeRate(Currency.CHF, Currency.GBP, 0.88));
		exchangeRates.add(new ExchangeRate(Currency.EUR, Currency.GBP, 0.83));
	}

	public Double convert(Currency from, Currency to, Double amount) {
		if (from == to) return amount;

		var rate = exchangeRates.stream()
			.filter(x -> x.from() == from && x.to() == to || x.from() == to && x.to() == from)
			.findFirst()
			.orElseThrow(() -> new IllegalArgumentException("Did not find rate for currencies " + from + " and " + to));

		var converted = rate.from() == from ? amount * rate.rate() : amount / rate.rate();

		return Math.round(converted * 100) / 100d;
	}
}
