package com.cryptocurrency.onetable;


import java.util.ArrayList;

import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import kong.unirest.json.JSONArray;
import kong.unirest.json.JSONObject;

public class GetMoney {

	public static JSONArray Currency(String currency) {

		// ******** REMOVE API KEY before committing *****

		final HttpResponse<String> jsonStringResponse = Unirest.get("https://api.nomics.com/v1/currencies/ticker")
				.queryString("key", "8381f81057e8766c11cd0109bae84864").queryString("ids", currency)
				.queryString("interval", "1d").asString();

		String json = jsonStringResponse.getBody();
		JSONArray currencyJson = new JSONArray(json);

		return currencyJson;
	}

	public ArrayList<Cryptomoney> money(JSONArray json) {
		
		ArrayList <Cryptomoney> crypto=new ArrayList<>();
		
		for (int idx = 0; idx < json.length(); idx++) {
			JSONObject currencyData = json.getJSONObject(idx);

			JSONObject key = (JSONObject) currencyData;

			String id = (String) key.get("id");
			String currency = (String) key.get("currency");
			String symbol = (String) key.get("symbol");
			String name = (String) key.get("name");
			String logo = (String) key.get("logo_url");
			

			Cryptomoney money=new Cryptomoney(id,currency,symbol,name,logo);
			crypto.add(money);
			
		//	System.out.printf("id: %s\ncurrency: %s\nsymbol: %s\nname: %s\nlogo: %s\n", id, currency, symbol, name,
		//			logo);
		//	System.out.println("---------------------");
		}
		return crypto;
	}

}