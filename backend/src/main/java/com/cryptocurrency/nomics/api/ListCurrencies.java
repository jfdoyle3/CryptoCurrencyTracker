package com.cryptocurrency.nomics.api;

import java.util.ArrayList;

import java.util.List;

import com.cryptocurrency.nomics.objects.CryptocurrencyHeader;

import kong.unirest.json.JSONArray;


public class ListCurrencies {
	
<<<<<<< HEAD
	private static String interval="1d";
	
	public static List<CryptocurrencyHeader> CreateCurrencyList(String userSearch) {
		
=======
private static String interval="";

	public static List<CryptocurrencyHeader> CreateCurrencyList(String userSearch) {

>>>>>>> Working
		JSONArray json = GetCurrency.Currencies(userSearch, interval);
		List<CryptocurrencyHeader> cryptoMoney = GetCurrency.CurrencyID(json);
		return cryptoMoney;

	}

	public static List<CryptocurrencyHeader> topTenCurrencies(String userSearch) {
		List<CryptocurrencyHeader> topTenList = new ArrayList<>();
<<<<<<< HEAD
		JSONArray json = GetCurrency.Currencies(userSearch,interval);
=======
		JSONArray json = GetCurrency.Currencies(userSearch, interval);
>>>>>>> Working
		List<CryptocurrencyHeader> cryptoMoney = GetCurrency.CurrencyID(json);
		for (int idx = 0; idx < 5; idx++) {
			topTenList.add(cryptoMoney.get(idx));
		}
		return topTenList;
	}
}
