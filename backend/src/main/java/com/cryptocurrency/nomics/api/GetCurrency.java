package com.cryptocurrency.nomics.api;

import java.util.ArrayList;
import java.util.List;

import com.cryptocurrency.nomics.objects.CryptocurrencyHeader;
import com.cryptocurrency.nomics.objects.CurrencyInfo;
import com.cryptocurrency.nomics.objects.CurrencyInterval;

import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import kong.unirest.json.JSONArray;
import kong.unirest.json.JSONObject;

public class GetCurrency {
	private static List<CryptocurrencyHeader> cryptoList = new ArrayList<>();
	private static List<CurrencyInfo> currencyInfoList=new ArrayList<>();
	private static List<CurrencyInterval> currencyIntervalList = new ArrayList<>();
	private static String maxSupply, circulating_supply, market_cap, volChgPct, marketCapChg, marketCapChgPct,
	volChange;
	private static long idCounter = 0;
	
	
	public static JSONArray Currencies(String currency, String interval) {

		// ******** REMOVE API KEY before committing *****
		final HttpResponse<String> jsonStringResponse = Unirest.get("https://api.nomics.com/v1/currencies/ticker")
				.queryString("key", "8381f81057e8766c11cd0109bae84864").queryString("ids", currency)
				.queryString("interval", interval).asString();

		String json = jsonStringResponse.getBody();
		JSONArray currencyJson = new JSONArray(json);
	//	System.out.println("Currencies: --> API Data: "+json.toString());
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
			String priceDate=(String) key.get("price_date");
			String priceTimeStamp=(String) key.get("price_timestamp");

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

			CurrencyInfo currencyInfo = new CurrencyInfo(++idCounter, symbol, price,priceDate,priceTimeStamp, circulating_supply, maxSupply,
					market_cap, rank, high, high_timestamp);
			currencyInfoList.add(currencyInfo);
//			System.out.printf("price: %s\nsupply: %s\nmax: %s\ncap: %s\nrank: %s\nhigh: %s\nhigh time: %s\n", price,circulating_supply, maxSupply, marketCap, rank, high, high_timestamp);
//			System.out.println("---------------------");

		}
		return currencyInfoList;
	}

	public static List<CurrencyInterval> CurrencyTimeInterval(JSONArray json, String interval) {
	
		for (int idx = 0; idx < json.length(); idx++) {
			//System.out.printf("\nGet Currency - interval method:   %d\n",currencyIntervalList.size());
			JSONObject currencyData = json.getJSONObject(idx);
			JSONObject key = (JSONObject) currencyData;
			String symbol = (String) key.get("symbol");
		//	System.out.println("\nGet Currency - interval method: Symbol:  "+symbol);
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
				// System.out.println("Time Interval: "+interval+" | Symbol: "+symbol+" |
				// Volume: "+volume+" | Price Chg: "+priceChange+" | Price %: "+priceChgPct+" |
				// Vol Chg: "+volChange+" | Vol %: "+volChgPct+" | Market: "+marketCapChg+" |
				// Market %: "+marketCapChgPct);
			} else {
				CurrencyInterval currencyInterval = new CurrencyInterval(++idCounter, "N/A", symbol, "N/A", "N/A",
						"N/A", "N/A", "N/A", "N/A", "N/A");
				currencyIntervalList.add(currencyInterval);
//				 System.out.println("Time Interval: "+interval+" | Symbol: "+symbol+" |
//				 Volume: N/A | Price Chg: N/A | Price %: N/A | Vol Chg: N/A | Vol %: N/A |
//				 Market: N/A | Market %: N/A");
			}

			// System.out.println("---------------------");
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