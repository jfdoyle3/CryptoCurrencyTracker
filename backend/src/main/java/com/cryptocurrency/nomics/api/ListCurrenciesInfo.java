package com.cryptocurrency.nomics.api;

import java.util.ArrayList;
import java.util.List;

import com.cryptocurrency.nomics.objects.CryptocurrencyHeader;
import com.cryptocurrency.nomics.objects.CurrencyInfo;

import kong.unirest.json.JSONArray;

public class ListCurrenciesInfo {

<<<<<<< HEAD
	private static String interval = "1d";

=======
	private static String interval="1d";
	
>>>>>>> Working
	public static List<CurrencyInfo> CreateCurrencyListInfo(String userSearch) {

		JSONArray json = GetCurrency.Currencies(userSearch, interval);
		List<CurrencyInfo> cryptoInfo = GetCurrency.CurrencyInfo(json);
		return cryptoInfo;

	}

	public static List<CryptocurrencyHeader> topTenCurrencies(String userSearch) {
		List<CryptocurrencyHeader> topTenList = new ArrayList<>();
		JSONArray json = GetCurrency.Currencies(userSearch, interval);
		List<CryptocurrencyHeader> cryptoMoney = GetCurrency.CurrencyID(json);
		for (int idx = 0; idx < 5; idx++) {
			topTenList.add(cryptoMoney.get(idx));
		}
		return topTenList;

	}
}
