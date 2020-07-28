package com.cryptocurrency.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cryptocurrency.backend.services.CurrencyInfoServices;
import com.cryptocurrency.nomics.objects.CurrencyInfo;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CurrencyInfoController {

	@Autowired
	private CurrencyInfoServices currencyInfoServices;

	// GET: All Currencies
	@GetMapping("/users/{username}/cryptocurrenciesInfo")
	public List<CurrencyInfo> getAllInfo(@PathVariable String username) {
		return currencyInfoServices.findAll();
	}

	// GET: A Currency
	@GetMapping("/users/{username}/cryptocurrencyInfo/{symbol}")
	public CurrencyInfo getByCurrencySymbol(@PathVariable String username, @PathVariable String symbol) {
		return currencyInfoServices.findBySymbol(symbol);
	}
//	
//	// GET: A Currency
//	@GetMapping("/users/{username}/cryptocurrencies/{currency}")
//	public CurrencyInfo getByCurrency(@PathVariable String username, @PathVariable String currency) {
//		return currencyServices.findByAnyCurrency(currency);
//	}
}
