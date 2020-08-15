package com.cryptocurrency.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cryptocurrency.entity.objects.CurrencyDailyPrice;
import com.cryptocurrency.nomics.objects.CurrencyInfo;

//@RestController
//@CrossOrigin(origins = "http://localhost:4200")
public class CurrencyDailyPriceController {

//	@Autowired
//	private CurrencyDailyPrice currencyDailyPriceServices;

	// GET: All Currencies
//	@GetMapping("/users/{username}/cryptocurrenciesInfo")
//	public List<CurrencyInfo> getAllInfo(@PathVariable String username) {
//		return currencyDailyPriceServices.findAll();
//	}
//
//	// GET: A Currency
//	@GetMapping("/users/{username}/cryptocurrencyInfo/{symbol}")
//	public CurrencyInfo getByCurrencySymbol(@PathVariable String username, @PathVariable String symbol) {
//		return currencyDailyPriceServices.findBySymbol(symbol);
//	}
//	
//	// GET: A Currency
//	@GetMapping("/users/{username}/cryptocurrencies/{currency}")
//	public CurrencyInfo getByCurrency(@PathVariable String username, @PathVariable String currency) {
//		return currencyServices.findByAnyCurrency(currency);
//	}
}
