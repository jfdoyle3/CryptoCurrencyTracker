package com.cryptocurrency.backend.payloads.api;
//package com.cryptocurrency.backend.payload.api;
//
//import java.util.List;
//
//import com.cryptocurrency.backend.payload.response.CurrencyInterval;
//
//import kong.unirest.json.JSONArray;
//
//public class ListCurrenciesInterval {
//
//	public static List<CurrencyInterval> createCurrencyIntervalList(String userSearch, String interval) {
//		JSONArray json = GetCurrency.Currencies(userSearch, interval);
//		List<CurrencyInterval> cryptoMoneyInterval = GetCurrency.CurrencyTimeInterval(json, interval);
//		return cryptoMoneyInterval;
//	}
//	
////	public static CurrencyInterval getCurrencyInterval(String currency, String interval) {
////		JSONArray json = GetCurrency.Currencies(currency, interval);
////		
////		return 
////	}
//}