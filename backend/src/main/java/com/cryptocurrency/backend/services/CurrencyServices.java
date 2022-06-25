package com.cryptocurrency.backend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;

import com.cryptocurrency.backend.payload.api.GetCurrency;
import com.cryptocurrency.backend.payload.response.Cryptocurrency;

import kong.unirest.json.JSONArray;

public class CurrencyServices {
	
    @Value("${api.key}")
    private String apiKey;
	
	public List<Cryptocurrency> currencyAPI(String cryptoCurrency, String apiKey) {
		String interval = "1d";
		GetCurrency gc=new GetCurrency();
		JSONArray json = gc.Currencies(cryptoCurrency, interval,apiKey);
		List<Cryptocurrency> currency=gc.Cryptocurrency(json);
		
		return currency;
	}

}
