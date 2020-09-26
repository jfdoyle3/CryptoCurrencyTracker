package get_api_data;

import java.util.ArrayList;
import java.util.List;

import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import kong.unirest.json.JSONArray;
import kong.unirest.json.JSONObject;
import objects.Cryptocurrencies;
import objects.Cryptocurrencies;
import objects.CurrencyInfo;
import objects.CurrencyInterval;

public class GetCurrency {
	private static List<Cryptocurrencies> cryptoList = new ArrayList<>();
	private static List<CurrencyInfo> currencyInfoList = new ArrayList<>();
	private static List<CurrencyInterval> currencyIntervalList = new ArrayList<>();
	private static long idCounter = 0;
	private static String maxSupply, circulating_supply, market_cap, volChgPct, marketCapChg, marketCapChgPct,
			volChange;

	public static JSONArray Currencies(String currency, String interval) {

		// ******** REMOVE API KEY before committing *****

		final HttpResponse<String> jsonStringResponse = Unirest.get("https://api.nomics.com/v1/currencies/ticker")
				.queryString("key", "8381f81057e8766c11cd0109bae84864").queryString("ids", currency)
				.queryString("interval", interval).asString();

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
			String ranking = (String) key.get("rank");
			Cryptocurrencies cryptoMoney = new Cryptocurrencies(++idCounter, id, currency, symbol, name,ranking,logo);
			cryptoList.add(cryptoMoney);

			System.out.printf("id: %s\ncurrency: %s\nsymbol: %s\nname: %s\nrank: %s\nlogo: %s\n", id, currency, symbol, name, ranking,logo);
			System.out.println("---------------------");
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


			String high = (String) key.get("high");
			String high_timestamp = (String) key.get("high_timestamp");

			CurrencyInfo currencyInfo = new CurrencyInfo(++idCounter, symbol, price,priceDate,priceTimeStamp, circulating_supply, maxSupply,
					market_cap, high, high_timestamp);
			currencyInfoList.add(currencyInfo);
			// System.out.printf("idx: %d | idCounter: %d\n",idx, idCounter);
			// System.out.printf("id: %d\n,symbol %s\n, price: %s\nsupply: %s\nmax: %s\ncap:
			// %s\nrank: %s\nhigh: %s\nhigh time: %s\n",idCounter,symbol,
			// price,circulating_supply, maxSupply, market_cap, rank, high, high_timestamp);
			// System.out.println("---------------------");

		}
		return currencyInfoList;
	}

	public static List<CurrencyInterval> CurrencyTimeInterval(JSONArray json, String interval) {

		for (int idx = 0; idx < json.length(); idx++) {
			currencyIntervalList.clear();
			JSONObject currencyData = json.getJSONObject(idx);
			JSONObject key = (JSONObject) currencyData;
			String symbol = (String) key.get("symbol");
			if (key.has(interval)) {
				JSONObject intervalTime = (JSONObject) key.get(interval);
				String volume = (String) intervalTime.get("volume");
				String priceChange = (String) intervalTime.get("price_change");
				String priceChgPct = (String) intervalTime.get("price_change_pct");
				if (intervalTime.has("volume_change")) {
					volChange = (String) intervalTime.get("volume_change");
				} else {
					volChange = "N/A";
				}
				if (intervalTime.has("volume_change_pct")) {
					volChgPct = (String) intervalTime.get("volume_change_pct");
				} else {
					volChgPct = "N/A";
				}
				if (intervalTime.has("market_cap_change")) {
					marketCapChg = (String) intervalTime.get("market_cap_change");
				} else {
					marketCapChg = "N/A";
				}
				if (intervalTime.has("market_cap_change_pct")) {
					marketCapChgPct = (String) intervalTime.get("market_cap_change_pct");
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
				
//			} else {
//				CurrencyInterval currencyInterval = new CurrencyInterval(++idCounter, interval, symbol, "N/A", "N/A",
//						"N/A", "N/A", "N/A", "N/A", "N/A");
//				currencyIntervalList.add(currencyInterval);
				// System.out.println("Time Interval: "+interval+" | Symbol: "+symbol+" |
				// Volume: N/A | Price Chg: N/A | Price %: N/A | Vol Chg: N/A | Vol %: N/A |
				// Market: N/A | Market %: N/A");
			}

			// System.out.println("---------------------");
		}
		return currencyIntervalList;
	}
}
