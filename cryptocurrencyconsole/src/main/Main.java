package main;

import database.DBConnection;
import get_api_data.GetCurrency;
import kong.unirest.json.JSONArray;
import kong.unirest.json.JSONObject;

public class Main {

	public static void main(String[] args) {

		// DBConnection.connectDB();

		JSONArray json = GetCurrency.Currencies("BTC,ETH");

	
		for(int idx=0; idx<json.length(); idx++) {
		JSONObject currencyData = json.getJSONObject(0);

		JSONObject jo = (JSONObject) currencyData;

		String id =  (String) jo.get("id");
		String currency = (String) jo.get("currency");
		String name = (String) jo.get("name");
		String logo = (String) jo.get("logo_url");
		String symbol = (String) jo.get("symbol");
		
		System.out.printf("id: %s\ncurrency: %s\nsymbol: %s\nname: %s\nlogo: %s\n",id,currency,symbol,name,logo);
		
		}
//BTC,ETH,USDT,XRP,BCH,BSV,LTC,BNB,EOS,ADA
	}

}