package com.hdfc.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyConversionController {

	@GetMapping("/convert")
	public double convertCurrency(@RequestParam String fromCurrency, @RequestParam String toCurrency,
			@RequestParam double amount) {
		
		
		double usdToInrRate = 73.0;
		double eurToInrRate = 88.0;

		if ("USD".equalsIgnoreCase(fromCurrency) && "INR".equalsIgnoreCase(toCurrency)) {
			return amount * usdToInrRate;
		} else if ("EUR".equalsIgnoreCase(fromCurrency) && "INR".equalsIgnoreCase(toCurrency)) {
			return amount * eurToInrRate;
		} else {
			throw new IllegalArgumentException("Unsupported currency conversion");
		}
	}
}
