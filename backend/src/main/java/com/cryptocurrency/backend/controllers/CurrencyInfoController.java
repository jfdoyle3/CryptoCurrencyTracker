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

//	// GET: Top Ten Currencies
//	@GetMapping("/users/{username}/cryptocurrencies/topTen")
//	public List<CurrencyInfo> getTopTen(@PathVariable String username) {
//		return currencyServices.listTopTen();
//	}
//	// GET: A Currency
	@GetMapping("/users/{username}/cryptocurrenciesInfo/id/{id}")
	public CurrencyInfo getByCurrencyId(@PathVariable String username, @PathVariable Long id) {
		return currencyInfoServices.findById(id);
	}
	// GET: A Currency
	@GetMapping("/users/{username}/cryptocurrenciesInfo/{currency}")
	public CurrencyInfo getByCurrency(@PathVariable String username, @PathVariable String currency) {
		return currencyInfoServices.findByAnyCurrency(currency);
	}
}
