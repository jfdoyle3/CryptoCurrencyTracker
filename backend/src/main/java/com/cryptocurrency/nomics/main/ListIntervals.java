package com.cryptocurrency.nomics.main;

import java.util.ArrayList;
import java.util.List;

import com.cryptocurrency.nomics.api.GetCurrency;
import com.cryptocurrency.nomics.objects.CurrencyInterval;

import kong.unirest.json.JSONArray;

public class ListIntervals {

	public static void main(String[] args) {
		String[] interval = { "1d","30d","365d","ytd" };

		String userSearch = "BTC";
		List<CurrencyInterval> intervalsList = new ArrayList<>();
		for (int idx = 0; idx < interval.length; idx++) {
			JSONArray json = GetCurrency.Currencies(userSearch, interval[idx]);
			// GetCurrency.CurrencyTimeInterval(json, interval);
			List<CurrencyInterval> cryptoMoneyInterval = GetCurrency.CurrencyTimeInterval(json, interval[idx]);

			for (CurrencyInterval crypto : cryptoMoneyInterval)

				System.out.println(crypto);

//	 Scanner myObj = new Scanner(System.in); 

			System.out.println("end of line");

			// BTC,ETH,USDT,XRP,BCH,BSV,LTC,BNB,EOS,ADA
		}
	}

}
