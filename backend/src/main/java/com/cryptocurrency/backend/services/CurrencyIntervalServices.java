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
	private static String[] interval = { "7d", "30d", "ytd" };
	
	public List<CurrencyInterval> getIntervals(String symbol) {
		String currencySymbol = symbol.toUpperCase();
		System.out.println("--> Interval Service - method: "+intervalsList.size());
		intervalsList.clear();
		System.out.printf("||||Interval Symbol %s||||\n",currencySymbol);
	//	List<CurrencyInterval> intervalsList = new ArrayList<>();
		for (int idx = 0; idx < interval.length; idx++) {
			JSONArray json = GetCurrency.Currencies(currencySymbol, interval[idx]);
			List<CurrencyInterval> cryptoMoneyInterval = GetCurrency.CurrencyTimeInterval(json, interval[idx]);
			intervalsList.add(cryptoMoneyInterval.get(idx));
			
		}
		return intervalsList;
	}
}
