package testhibernate;

import java.util.ArrayList;
import java.util.List;

import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import kong.unirest.json.JSONArray;
import kong.unirest.json.JSONObject;
import objects.Cryptocurrencies;
import objects.CurrencyInfo;
import objects.CurrencyInterval;

public class APIData {
	
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

			Cryptocurrencies cryptoMoney = new Cryptocurrencies(++idCounter, id, currency, symbol, name, logo);
			cryptoList.add(cryptoMoney);

			System.out.printf("id: %s\ncurrency: %s\nsymbol: %s\nname: %s\nlogo: %s\n", id, currency, symbol, name,
					logo);
			System.out.println("---------------------");
		}
		return cryptoList;
	}

}
