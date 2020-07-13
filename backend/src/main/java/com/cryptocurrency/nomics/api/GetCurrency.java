package com.cryptocurrency.nomics.api;

import java.util.ArrayList;
import java.util.List;

import com.cryptocurrency.nomics.objects.CryptocurrencyHeader;
import com.cryptocurrency.nomics.objects.CurrencyInfo;

import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import kong.unirest.json.JSONArray;
import kong.unirest.json.JSONObject;

public class GetCurrency {
	private static List<CryptocurrencyHeader> cryptoList = new ArrayList<>();
	private static List<CurrencyInfo> currencyInfoList=new ArrayList<>();
	private static String maxSupply, circulating_supply, market_cap;
	private static long idCounter = 0;
	
	
	public static JSONArray Currencies(String currency) {

		// ******** REMOVE API KEY before committing *****

		final HttpResponse<String> jsonStringResponse = Unirest.get("https://api.nomics.com/v1/currencies/ticker")
				.queryString("key", "8381f81057e8766c11cd0109bae84864").queryString("ids", currency)
				.queryString("interval", "1d").asString();

		String json = jsonStringResponse.getBody();
		JSONArray currencyJson = new JSONArray(json);
		System.out.println("API Data: "+json.toString());
		return currencyJson;
	}

	public static List<CryptocurrencyHeader> CurrencyID(JSONArray json) {

		for (int idx = 0; idx < json.length(); idx++) {
			JSONObject currencyData = json.getJSONObject(idx);

			JSONObject key = (JSONObject) currencyData;

			String id = (String) key.get("id");
			String currency = (String) key.get("currency");
			String name = (String) key.get("name");
			String logo = (String) key.get("logo_url");
			String symbol = (String) key.get("symbol");
			String rank= (String) key.get("rank");
			
			CryptocurrencyHeader cryptoMoney=new CryptocurrencyHeader(++idCounter, id,currency, symbol,name,logo,rank);
			cryptoList.add(cryptoMoney);
			
		}
		return cryptoList;
	}

	public static List<CurrencyInfo> CurrencyInfo(JSONArray json) {

		for (int idx = 0; idx < json.length(); idx++) {
			JSONObject currencyData = json.getJSONObject(idx);

			JSONObject key = (JSONObject) currencyData;
			String symbol = (String) key.get("symbol");
			String price = (String) key.get("price");

			if (key.has("circulating_supply")) {
				circulating_supply = (String) key.get("circulating_supply");
			} else {
				circulating_supply = "N/A";
			}
			if (key.has("max_supply")) {
				maxSupply = (String) key.get("max_supply");
			} else {
				maxSupply = "N/A";
			}
			if (key.has("market_cap")) {
				market_cap = (String) key.get("market_cap");
			} else {
				market_cap = "N/A";
			}

			String rank = (String) key.get("rank");
			String high = (String) key.get("high");
			String high_timestamp = (String) key.get("high_timestamp");

			CurrencyInfo currencyInfo = new CurrencyInfo(++idCounter, symbol, price, circulating_supply, maxSupply,
					market_cap, rank, high, high_timestamp);
			currencyInfoList.add(currencyInfo);
//			System.out.printf("price: %s\nsupply: %s\nmax: %s\ncap: %s\nrank: %s\nhigh: %s\nhigh time: %s\n", price,circulating_supply, maxSupply, marketCap, rank, high, high_timestamp);
//			System.out.println("---------------------");

		}
		return currencyInfoList;
	}

	public static void CurrencyInterval(JSONArray json) {

		for (int idx = 0; idx < json.length(); idx++) {
			JSONObject currencyData = json.getJSONObject(idx);

			JSONObject key = (JSONObject) currencyData;

			String priceDate = (String) key.get("price_date");
			String priceTimestamp = (String) key.get("price_timestamp");

			System.out.printf("price Date: %s\nprice Timestamp: %s\n", priceDate, priceTimestamp);
			System.out.println("---------------------");
		}
	}
}