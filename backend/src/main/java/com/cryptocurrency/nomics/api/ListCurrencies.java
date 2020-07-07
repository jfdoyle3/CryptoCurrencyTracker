package com.cryptocurrency.nomics.api;

import java.util.ArrayList;
import java.util.List;

import com.cryptocurrency.nomics.objects.Cryptocurrency;

import kong.unirest.json.JSONArray;

public class ListCurrencies {

	public static List<Cryptocurrency> CreateCurrencyList(String userSearch) {

		JSONArray json = GetCurrency.Currencies(userSearch);
		List<Cryptocurrency> cryptoMoney = GetCurrency.CurrencyID(json);
		return cryptoMoney;

	}

	public static List<Cryptocurrency> topTenCurrencies(String userSearch) {
		List<Cryptocurrency> topTenList = new ArrayList<>();
		JSONArray json = GetCurrency.Currencies(userSearch);
		List<Cryptocurrency> cryptoMoney = GetCurrency.CurrencyID(json);
		for (int idx = 0; idx < 10; idx++) {
			topTenList.add(cryptoMoney.get(idx));
		}
		return topTenList;

	}
}
