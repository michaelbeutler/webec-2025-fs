package com.fhnw.webec.converter.controller;

import com.fhnw.webec.converter.data.Currency;
import com.fhnw.webec.converter.service.CurrencyConverterService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class CurrencyConverterController {

	private CurrencyConverterService service;

	public CurrencyConverterController(CurrencyConverterService service) {
		this.service = service;
	}

	@GetMapping("currency")
	public String convert(Currency from, Currency to, Double amount, Model model) {

		model.addAttribute("currencies", Currency.values());
		model.addAttribute("from", from);
		model.addAttribute("to", to);
		model.addAttribute("amount", amount);

		if (from != null && to != null && amount != null) {
			model.addAttribute("result", service.convert(from, to, amount));
		}

		return "currency-converter";
	}

}
