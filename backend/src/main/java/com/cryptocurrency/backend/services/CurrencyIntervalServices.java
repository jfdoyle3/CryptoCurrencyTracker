package com.cryptocurrency.backend.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.cryptocurrency.nomics.api.GetCurrency;
import com.cryptocurrency.nomics.objects.CurrencyInterval;

import kong.unirest.json.JSONArray;

@Service
public class CurrencyIntervalServices {

	private static List<CurrencyInterval> intervalsList = new ArrayList<>();
	private static String[] interval = { "1d", "30d", "365d", "ytd" };

	public List<CurrencyInterval> getIntervals(String userSearch) {

		for (int idx = 0; idx < interval.length; idx++) {
			JSONArray json = GetCurrency.Currencies(userSearch, interval[idx]);
			List<CurrencyInterval> cryptoMoneyInterval = GetCurrency.CurrencyTimeInterval(json, interval[idx]);

			for (CurrencyInterval crypto : cryptoMoneyInterval) {
				intervalsList.add(crypto);
				System.out.println(crypto);
			}
		}
		return intervalsList;
	}
}
