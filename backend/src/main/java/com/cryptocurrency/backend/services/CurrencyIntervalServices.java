package com.cryptocurrency.backend.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.cryptocurrency.nomics.api.GetCurrency;
import com.cryptocurrency.nomics.objects.CurrencyInterval;

import kong.unirest.json.JSONArray;

@Service
public class CurrencyIntervalServices {

	private static String[] interval = { "7d", "30d", "ytd" };

	public List<CurrencyInterval> getIntervals(String currencySymbol) {
		String symbol = currencySymbol.toUpperCase();

		List<CurrencyInterval> intervalsList = new ArrayList<>();
		for (int idx = 0; idx < interval.length; idx++) {

			JSONArray json = GetCurrency.Currencies(symbol, interval[idx]);

			List<CurrencyInterval> currencyInterval = GetCurrency.CurrencyTimeInterval(json, interval[idx]);

			intervalsList.add(currencyInterval.get(0));
		}
		return intervalsList;
	}
}
