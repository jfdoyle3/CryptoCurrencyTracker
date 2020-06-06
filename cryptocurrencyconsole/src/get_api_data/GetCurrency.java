package get_api_data;

import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import kong.unirest.json.JSONArray;
import kong.unirest.json.JSONObject;

public class GetCurrency {

	public static JSONArray Currencies(String currency) {

		// ******** REMOVE API KEY before committing *****

		final HttpResponse<String> jsonStringResponse = Unirest.get("https://api.nomics.com/v1/currencies/ticker")
				.queryString("key", "").queryString("ids", currency)
				.queryString("interval", "1d").asString();

		String json = jsonStringResponse.getBody();
		JSONArray currencyJson = new JSONArray(json);

		return currencyJson;
	}

	public static void CurrencyID(JSONArray json) {

		for (int idx = 0; idx < json.length(); idx++) {
			JSONObject currencyData = json.getJSONObject(idx);

			JSONObject objects = (JSONObject) currencyData;

			String id = (String) objects.get("id");
			String currency = (String) objects.get("currency");
			String name = (String) objects.get("name");
			String logo = (String) objects.get("logo_url");
			String symbol = (String) objects.get("symbol");

			System.out.printf("id: %s\ncurrency: %s\nsymbol: %s\nname: %s\nlogo: %s\n", id, currency, symbol, name,
					logo);
			System.out.println("---------------------");
		}
	}

	public static void CurrencyInfo(JSONArray json) {
		String max_supply;
		for (int idx = 0; idx < json.length(); idx++) {
			JSONObject currencyData = json.getJSONObject(idx);

			JSONObject objects = (JSONObject) currencyData;

			String price = (String) objects.get("price");
			String circulating_supply = (String) objects.get("circulating_supply");

			if (objects.has("max_supply")) {
				max_supply = (String) objects.get("max_supply");
			} else {
				max_supply = "N/A";
			}

			String market_cap = (String) objects.get("market_cap");
			String rank = (String) objects.get("rank");
			String high = (String) objects.get("high");
			String high_timestamp = (String) objects.get("high_timestamp");

			System.out.printf("price: %s\nsupply: %s\nmax: %s\ncap: %s\nrank: %s\nhigh: %s\nhigh time: %s\n", price,
					circulating_supply, max_supply, market_cap, rank, high, high_timestamp);
			System.out.println("---------------------");
		}
	}

	public static void CurrencyInterval(JSONArray json) {

		for (int idx = 0; idx < json.length(); idx++) {
			JSONObject currencyData = json.getJSONObject(idx);

			JSONObject objects = (JSONObject) currencyData;

			String priceDate = (String) objects.get("price_date");
			String priceTimestamp = (String) objects.get("price_timestamp");

			System.out.printf("price Date: %s\nprice Timestamp: %s\n", priceDate, priceTimestamp);
			System.out.println("---------------------");
		}
	}
}