package com.cryptocurrency.backend.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.cryptocurrency.nomics.api.GetCurrency;
import com.cryptocurrency.nomics.objects.CurrencyInterval;

import kong.unirest.json.JSONArray;

@Service
public class CurrencyIntervalServices {

	// private static String[] interval = { "7d", "30d", "ytd" };
	private static String interval = "7d";

	public List<CurrencyInterval> getIntervals(String currencySymbol) {
		String symbol = currencySymbol.toUpperCase();

		// List<CurrencyInterval> intervalsList = new ArrayList<>();
		// for (int idx = 0; idx < interval.length; idx++) {
		
		System.out.printf("||||inFor Loop: Interval Symbol %s||||\n", symbol);
		
		JSONArray json = GetCurrency.Currencies(symbol, interval);
		System.out.println("|| JSON: "+json);
		List<CurrencyInterval> currencyInterval = GetCurrency.CurrencyTimeInterval(json, interval);

		System.out.println(currencyInterval);
		// System.out.println("---> Interval Service List: before returning <---");
		 for (CurrencyInterval intervals : currencyInterval) {
		
		 System.out.println("||| " + intervals);

		// intervalsList.add(currencyInterval);
		 }
		// System.out.println("---> Interval Service List: returning <---");
		// }
//		
//		System.out.println("--->end of loop <---");

		return currencyInterval;
	}
}
