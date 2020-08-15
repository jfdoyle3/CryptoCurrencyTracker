package com.cryptocurrency.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cryptocurrency.backend.services.CryptocurrencyServices;
import com.cryptocurrency.entity.objects.Cryptocurrency;
import com.cryptocurrency.nomics.objects.CryptocurrencyHeader;
import com.cryptocurrency.testhibernate.EntityDBWriteOneRecordTest;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CurrencyController {
//	Cryptocurrency
	@Autowired
	private CryptocurrencyServices cryptocurrencyServices;

//	// GET: All Currencies
	@GetMapping("/users/{username}/cryptocurrencies")
	public List<Cryptocurrency> getAllCurrencies(@PathVariable String username) {
		return cryptocurrencyServices.findAll();
	}

	// GET: Top Ten Currencies
	@GetMapping("/users/{username}/cryptocurrencies/topfive")
	public List<Cryptocurrency> getTopTen(@PathVariable String username) {
		return cryptocurrencyServices.listTopFive();
	}
	// GET: A Currency by Id
//	@GetMapping("/users/{username}/cryptocurrency/id/{id}")
//	public CryptocurrencyHeader getByCurrencyId(@PathVariable String username, @PathVariable Long id) {
//		return currencyServices.findById(id);
//	}
	
	// GET: A Currency by Symbol
//	@GetMapping("/users/{username}/cryptocurrency/{symbol}")
//	public Cryptocurrency getByCurrencySymbol(@PathVariable String username, @PathVariable String symbol) {
//	
//		return currencyServices.findByCurrencyBySymbol(symbol);
//	}
//	@PostMapping("/users/{username}/cryptocurrency/create")
//	public Cryptocurrency getByCurrencySymbol(@PathVariable String username) {
//		EntityDBWriteOneRecordTest.RunASession();
//		return null;
//				
//		
//	}
}
