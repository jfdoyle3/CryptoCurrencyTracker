package com.cryptocurrency.NomicsAPI.get_api_data;

import java.util.ArrayList;
import java.util.List;

import com.cryptocurrency.NomicsAPI.Objects.Cryptocurrencies;

import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import kong.unirest.json.JSONArray;
import kong.unirest.json.JSONObject;

public class GetCurrency {
	private static List<Cryptocurrencies> cryptoList = new ArrayList<>();
	private static long idCounter = 0;
	
	
	public static JSONArray Currencies(String currency) {

		// ******** REMOVE API KEY before committing *****

		final HttpResponse<String> jsonStringResponse = Unirest.get("https://api.nomics.com/v1/currencies/ticker")
				.queryString("key", "8381f81057e8766c11cd0109bae84864").queryString("ids", currency)
				.queryString("interval", "1d").asString();

		String json = jsonStringResponse.getBody();
		JSONArray currencyJson = new JSONArray(json);

		return currencyJson;
	}

	public static List<Cryptocurrencies> CurrencyID(JSONArray json) {

		for (int idx = 0; idx < json.length(); idx++) {
			JSONObject currencyData = json.getJSONObject(idx);

			JSONObject key = (JSONObject) currencyData;

			String id = (String) key.get("id");
			String currency = (String) key.get("currency");
			String name = (String) key.get("name");
			String logo = (String) key.get("logo_url");
			String symbol = (String) key.get("symbol");
			
			Cryptocurrencies cryptoMoney=new Cryptocurrencies(++idCounter, id,currency, symbol,name,logo);
			cryptoList.add(cryptoMoney);
			
		//	System.out.printf("id: %s\ncurrency: %s\nsymbol: %s\nname: %s\nlogo: %s\n", id, currency, symbol, name,
		//			logo);
		//	System.out.println("---------------------");
		}
		return cryptoList;
	}

	public static void CurrencyInfo(JSONArray json) {
		String max_supply;
		for (int idx = 0; idx < json.length(); idx++) {
			JSONObject currencyData = json.getJSONObject(idx);

			JSONObject key = (JSONObject) currencyData;

			String price = (String) key.get("price");
			String circulating_supply = (String) key.get("circulating_supply");

			if (key.has("max_supply")) {
				max_supply = (String) key.get("max_supply");
			} else {
				max_supply = "N/A";
			}

			String market_cap = (String) key.get("market_cap");
			String rank = (String) key.get("rank");
			String high = (String) key.get("high");
			String high_timestamp = (String) key.get("high_timestamp");

			System.out.printf("price: %s\nsupply: %s\nmax: %s\ncap: %s\nrank: %s\nhigh: %s\nhigh time: %s\n", price,
					circulating_supply, max_supply, market_cap, rank, high, high_timestamp);
			System.out.println("---------------------");
		}
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