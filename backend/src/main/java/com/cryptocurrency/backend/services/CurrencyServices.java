package com.cryptocurrency.backend.services;


import com.cryptocurrency.backend.payload.api.GetCurrency;

import kong.unirest.json.JSONArray;

public class CurrencyServices {

//	@Value("${api.key}")
//	private String apiKey;

	public JSONArray callAPI(String currencies, String interval,String apiKey) {
		String upperCurrencies = currencies.toUpperCase();
		String setInterval=!interval.equals("") ? interval : "1d";
		GetCurrency gc = new GetCurrency();
		JSONArray json = gc.Currencies(upperCurrencies, setInterval, apiKey);
		
		return json;
	}
	
//	public List<Cryptocurrency> getCurrencies(){
//		// List<Cryptocurrency> currency = gc.Cryptocurrency(json);
//		
//	}

}
