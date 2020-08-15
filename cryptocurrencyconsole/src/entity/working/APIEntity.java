package entity.working;

import java.util.ArrayList;
import java.util.List;

import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import kong.unirest.json.JSONArray;
import kong.unirest.json.JSONObject;

public class APIEntity {
	private static List<CryptocurrencyEntity> cryptoList = new ArrayList<>();
	private static List<CurrencyDailyPriceEntity> currencyInfoList = new ArrayList<>();
	private static List<CurrencyInterval> currencyIntervalList = new ArrayList<>();
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

	public static List<CryptocurrencyEntity> CurrencyID(JSONArray json) {

		for (int idx = 0; idx < json.length(); idx++) {
			JSONObject currencyData = json.getJSONObject(idx);

			JSONObject key = (JSONObject) currencyData;

			String currency_id = (String) key.get("id");
			String currency = (String) key.get("currency");
			String name = (String) key.get("name");
			String symbol = (String) key.get("symbol");
			String ranking = (String) key.get("rank");
			String logo = (String) key.get("logo_url");

			CryptocurrencyEntity cryptoMoney = new CryptocurrencyEntity(currency_id, currency, symbol, name, logo, ranking);
			cryptoList.add(cryptoMoney);

		}
		return cryptoList;
	}

	public static List<CurrencyDailyPriceEntity> CurrencyInfo(JSONArray json) {

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

			CurrencyDailyPriceEntity currencyInfo = new CurrencyDailyPriceEntity(symbol, price, priceDate, priceTimeStamp, circulating_supply,
					maxSupply, market_cap, high, high_timestamp);
			currencyInfoList.add(currencyInfo);
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
				CurrencyInterval currencyInterval = new CurrencyInterval(symbol, interval, volume, priceChange,
						priceChgPct, volChange, volChgPct, marketCapChg, marketCapChgPct);
				currencyIntervalList.add(currencyInterval);
			}
		}
		return currencyIntervalList;
	}
}
