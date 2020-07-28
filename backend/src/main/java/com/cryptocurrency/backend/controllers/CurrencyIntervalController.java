package com.cryptocurrency.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cryptocurrency.backend.services.CurrencyIntervalServices;
import com.cryptocurrency.nomics.objects.CurrencyInterval;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CurrencyIntervalController {

	@Autowired
	private CurrencyIntervalServices currencyIntervalServices;

	// GET: All Currencies
	@GetMapping("/users/{username}/cryptocurrenciesInterval/{symbol}")
	public List<CurrencyInterval> getAllInfo(@PathVariable String username,@PathVariable String symbol ) {
		return currencyIntervalServices.getIntervals(symbol);
	}

}
