package com.cryptocurrency.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cryptocurrency.backend.services.CurrencyServices;
import com.cryptocurrency.nomics.objects.CryptocurrencyHeader;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CurrencyController {

	@Autowired
	private CurrencyServices currencyServices;

	// GET: All Currencies
	@GetMapping("/users/{username}/cryptocurrencies")
	public List<CryptocurrencyHeader> getAllCurrencies(@PathVariable String username) {
		return currencyServices.findAll();
	}

	// GET: Top Ten Currencies
	@GetMapping("/users/{username}/cryptocurrencies/topfive")
	public List<CryptocurrencyHeader> getTopTen(@PathVariable String username) {
		return currencyServices.listTopFive();
	}
	// GET: A Currency by Id
	@GetMapping("/users/{username}/cryptocurrency/id/{id}")
	public CryptocurrencyHeader getByCurrencyId(@PathVariable String username, @PathVariable Long id) {
		return currencyServices.findById(id);
	}
	
	// GET: A Currency by Symbol
	@GetMapping("/users/{username}/cryptocurrency/{symbol}")
	public CryptocurrencyHeader getByCurrencySymbol(@PathVariable String username, @PathVariable String symbol) {
		return currencyServices. findByCurrencyBySymbol(symbol);
	}
}
