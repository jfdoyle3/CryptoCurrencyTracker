package com.cryptocurrency.backend.services;

<<<<<<< HEAD
<<<<<<< HEAD
import java.util.List;

import org.springframework.stereotype.Service;

import com.cryptocurrency.nomics.api.ListCurrenciesInterval;
import com.cryptocurrency.nomics.objects.CurrencyInterval;

@Service
public class CurrencyIntervalServices {
	// private String defaultSearch="BTC,ETH,USDT,XRP,BCH,BSV,LTC,BNB,EOS,ADA";
	private String defaultSearch = "";
	private String defaultInterval="";
	private long idCounter = 0;

	// Show All currencies in List
	public List<CurrencyInterval> findAll() {
		List<CurrencyInterval> currencyIntervalList = ListCurrenciesInterval.createCurrencyIntervalList(defaultSearch, defaultInterval);
		return currencyIntervalList;
	}

	public List<CurrencyInterval> currencyDayInterval(String symbol, String interval) {
		String currencySymbol = symbol.toUpperCase();
		if(interval.equals("all")) {
			interval="7d,ytd";
		}
		List<CurrencyInterval> currencyInterval = ListCurrenciesInterval.createCurrencyIntervalList(currencySymbol, interval);
		return currencyInterval;
	}

//	public List<CurrencyInfo> listTopTen() {
//		List<CurrencyInfo> topTenList = new ArrayList<>();
//		for (int idx = 0; idx < 10; idx++) {
//			topTenList.add(currencyList.get(idx));
//		}
//
//		return topTenList;
//
//	}

	// Find A Currency in the List
//	public CurrencyInfo findById(long id) {
//		for (CurrencyInfo currencyInfo : currencyInfoList) {
//			if (currencyInfo.getId() == id) {
//			//	System.out.println(currency);
//				return currencyInfo;
//			}
//
//		}
//		return null;
//}
}
=======

=======
import java.util.ArrayList;
import java.util.List;
>>>>>>> Working

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
>>>>>>> Working
