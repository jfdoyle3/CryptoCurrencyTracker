package com.cryptocurrency.nomics.api;

import java.util.ArrayList;
import java.util.List;

import com.cryptocurrency.entity.objects.Cryptocurrency;
import com.cryptocurrency.entity.objects.CurrencyDailyPrice;
import com.cryptocurrency.nomics.objects.CurrencyInterval;

import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import kong.unirest.json.JSONArray;
import kong.unirest.json.JSONObject;

public class GetCurrency {
	private static List<Cryptocurrency> cryptocurrencyList = new ArrayList<>();
	private static List<CurrencyDailyPrice> currencyDailyPriceEntityList = new ArrayList<>();
	private static List<CurrencyInterval> currencyIntervalList = new ArrayList<>();
	private static String maxSupply, circulating_supply, market_cap, volChgPct, marketCapChg, marketCapChgPct,
			volChange;
	private static int idCounter = 0;

	public static JSONArray Currencies(String currency, String interval) {

	
		final HttpResponse<String> jsonStringResponse = Unirest.get("https://api.nomics.com/v1/currencies/ticker")
				.queryString("key", "8381f81057e8766c11cd0109bae84864").queryString("ids", currency)
				.queryString("interval", interval).asString();

		String json = jsonStringResponse.getBody();
		JSONArray currencyJson = new JSONArray(json);
		return currencyJson;
	}

	public static List<Cryptocurrency> Cryptocurrency(JSONArray json) {

		for (int idx = 0; idx < json.length(); idx++) {
			JSONObject currencyData = json.getJSONObject(idx);

			JSONObject key = (JSONObject) currencyData;

			String currency_id = (String) key.get("id");
			String currency = (String) key.get("currency");
			String name = (String) key.get("name");
			String logo = (String) key.get("logo_url");
			String symbol = (String) key.get("symbol");
			String rank = (String) key.get("rank");

			Cryptocurrency cryptocurrency = new Cryptocurrency(currency_id, currency, symbol, name, logo,
					rank);
			cryptocurrencyList.add(cryptocurrency);

		}
		return cryptocurrencyList;
	}

	public static List<CurrencyDailyPrice> CurrencyDailyPrice(JSONArray json) {

		for (int idx = 0; idx < json.length(); idx++) {

			JSONObject currencyData = json.getJSONObject(idx);

			JSONObject key = (JSONObject) currencyData;
			String symbol = (String) key.get("symbol");
			String price = (String) key.get("price");
			String priceDate = (String) key.get("price_date");
			String priceTimeStamp = (String) key.get("price_timestamp");

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

			String high = (String) key.get("high");
			String high_timestamp = (String) key.get("high_timestamp");

			CurrencyDailyPrice currencyDailyPriceEntity = new CurrencyDailyPrice(symbol, price, priceDate,
					priceTimeStamp, circulating_supply, maxSupply, market_cap, high, high_timestamp);
			currencyDailyPriceEntityList.add(currencyDailyPriceEntity);
		}
		return currencyDailyPriceEntityList;
	}

	public static List<CurrencyInterval> CurrencyTimeInterval(JSONArray json, String interval) {
		currencyIntervalList.clear();
		for (int idx = 0; idx < json.length(); idx++) {

			JSONObject currencyData = json.getJSONObject(idx);
			JSONObject key = (JSONObject) currencyData;
			String symbol = (String) key.get("symbol");
			// System.out.println("\nGet Currency - interval method: Symbol: "+symbol);
			if (key.has(interval)) {
				JSONObject intervalKey = (JSONObject) key.get(interval);
				String volume = (String) intervalKey.get("volume");
				String priceChange = (String) intervalKey.get("price_change");
				String priceChgPct = (String) intervalKey.get("price_change_pct");
				if (intervalKey.has("volume_change")) {
					volChange = (String) intervalKey.get("volume_change");
				} else {
					volChange = "N/A";
				}
				if (intervalKey.has("volume_change_pct")) {
					volChgPct = (String) intervalKey.get("volume_change_pct");
				} else {
					volChgPct = "N/A";
				}
				if (intervalKey.has("market_cap_change")) {
					marketCapChg = (String) intervalKey.get("market_cap_change");
				} else {
					marketCapChg = "N/A";
				}
				if (intervalKey.has("market_cap_change_pct")) {
					marketCapChgPct = (String) intervalKey.get("market_cap_change_pct");
				} else {
					marketCapChgPct = "N/A";
				}

				CurrencyInterval currencyInterval = new CurrencyInterval(++idCounter, interval, symbol, volume,
						priceChange, priceChgPct, volChange, volChgPct, marketCapChg, marketCapChgPct);
				currencyIntervalList.add(currencyInterval);

			} else {
				CurrencyInterval currencyInterval = new CurrencyInterval(++idCounter, "N/A", symbol, "N/A", "N/A",
						"N/A", "N/A", "N/A", "N/A", "N/A");
				currencyIntervalList.add(currencyInterval);
			}
		}

		return currencyIntervalList;
	}

	public static void CurrencyTimeStamp(JSONArray json) {

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