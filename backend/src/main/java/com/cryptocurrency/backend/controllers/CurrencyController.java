package com.cryptocurrency.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cryptocurrency.backend.services.CurrencyServices;
import com.cryptocurrency.nomics.objects.Cryptocurrency;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CurrencyController {

	@Autowired
	private CurrencyServices currencyServices;

	// GET: All Currencies
	@GetMapping("/users/{username}/cryptocurrencies")
	public List<Cryptocurrency> getAllTodos(@PathVariable String username) {
		return currencyServices.findAll();
	}


	// GET: Top Ten Currencies
	@GetMapping("/users/{username}/cryptocurrencies/topTen")
	public List<Cryptocurrency> getTopTen(@PathVariable String username) {
		return currencyServices.listTopTen();
	}
	// GET: A Currency
	@GetMapping("/users/{username}/cryptocurrencies/id/{currencyId}")
	public Cryptocurrency getByCurrencyId(@PathVariable String username, @PathVariable Long id) {
		return currencyServices.findById(id);
	}
	
	// GET: A Currency
	@GetMapping("/users/{username}/cryptocurrencies/{currency}")
	public Cryptocurrency getByCurrency(@PathVariable String username, @PathVariable String currency) {
		return currencyServices.findByAnyCurrency(currency);
	}
}
