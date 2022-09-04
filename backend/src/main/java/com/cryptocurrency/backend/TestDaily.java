package com.cryptocurrency.backend;

import com.cryptocurrency.backend.payloads.api.GetCurrency;


import kong.unirest.json.JSONArray;

public class TestDaily {

	public static void main(String[] args) {
		String apiKey="8381f81057e8766c11cd0109bae84864";
		String upperCurrencySymbol="BTC";
    	String interval="1d";
    	System.out.println("TestDaily >>==> "+upperCurrencySymbol);
    	GetCurrency gc=new GetCurrency();
    	JSONArray json = gc.Currencies(upperCurrencySymbol, interval,apiKey);
	}

}
