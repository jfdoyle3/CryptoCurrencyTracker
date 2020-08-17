package com.cryptocurrency.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cryptocurrency.entity.dao.CryptocurrencyDAO;
import com.cryptocurrency.entity.objects.Cryptocurrency;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CurrencyController {

	@Autowired
	//private CryptocurrencyServices cryptocurrencyServices;
	private CryptocurrencyDAO cryptocurrencyDAO;
	

// GET: All Currencies
	@GetMapping("/users/{username}/cryptocurrencies")
	public String listCurrencies(Model theModel) {
	List<Cryptocurrency> currencies=CryptocurrencyDAO.getCurrency();
	
	theModel.addAttribute("Cryptocurrency", currencies);
	
	return null;
	}
}	
