package com.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cryptocurrency.backend.services.CryptocurrencyServices;

// Entity use this import to read from a Database.
import com.cryptocurrency.entity.objects.Cryptocurrency;

// Real Time using ArrayList to store the data.
//import com.cryptocurrency.nomics.objects.Cryptocurrency;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CurrencyController {

	@Autowired
	private CryptocurrencyServices cryptocurrencyServices;

	// GET: All Currencies
	@GetMapping("/users/{username}/cryptocurrencies")
	public List<Cryptocurrency> getAllCurrencies(@PathVariable String username) {
		System.out.println("---> All Controller running <---");
		return cryptocurrencyServices.findAll();
	}

	// GET: Top Five Currencies
	@GetMapping("/users/{username}/cryptocurrency/topFive")
	public List<Cryptocurrency> getTopFive(@PathVariable String username) {
		System.out.println("---> TopFive Controller running <---");
		return cryptocurrencyServices.listTopFive();
	}
	// GET: A Currency by Id
	@GetMapping("/users/{username}/cryptocurrency/symbol/{symbol}")
	public Cryptocurrency getByCurrencySymbol(@PathVariable String username, @PathVariable String symbol) {
		System.out.println("---> Symbol Controller running <---");
		return cryptocurrencyServices.findByCurrencyBySymbol(symbol);
	}
	

//	@PostMapping("/users/{username}/cryptocurrency/create")
//	public Cryptocurrency getByCurrencySymbol(@PathVariable String username) {
//		EntityDBWriteOneRecordTest.RunASession();
//		return null;
//				
//		
//	}
}

