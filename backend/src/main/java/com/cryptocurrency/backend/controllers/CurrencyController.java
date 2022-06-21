package com.cryptocurrency.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import com.cryptocurrency.backend.entity.objects.CryptocurrencyInfo;
import com.cryptocurrency.backend.payload.api.GetCurrency;
import com.cryptocurrency.backend.payload.response.Cryptocurrency;
import com.cryptocurrency.backend.repository.CryptocurrencyInfoRepository;

import kong.unirest.json.JSONArray;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class CurrencyController {

	@Autowired
	private CryptocurrencyInfoRepository repository;

	
    @Value("${api.key}")
    private String apiKey;

    @GetMapping("/currency/{q}")
    public ResponseEntity<List<Cryptocurrency>> cryptoHeader(@PathVariable String q) {
		String interval = "1d";
		GetCurrency gc=new GetCurrency();
		JSONArray json = gc.Currencies(q, interval,apiKey);
		List<Cryptocurrency> currency=gc.Cryptocurrency(json);
		for(Cryptocurrency item : currency) {
			CryptocurrencyInfo ci=new CryptocurrencyInfo(item.getCurrency_id(),item.getCurrency(),item.getSymbol(),item.getName(),item.getRanking(),item.getLogoUrl());
			repository.save(ci);
		}
        return ResponseEntity.ok(currency);
    }
}
