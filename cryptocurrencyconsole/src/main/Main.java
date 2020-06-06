package main;

import database.DBConnection;
import get_api_data.GetCurrency;
import kong.unirest.json.JSONArray;
import kong.unirest.json.JSONObject;

public class Main {

	public static void main(String[] args) {

		// DBConnection.connectDB();

		JSONArray json = GetCurrency.Currencies("BTC,ETH");
		GetCurrency.CurrencyID(json);
		GetCurrency.CurrencyInfo(json);
	
	
//BTC,ETH,USDT,XRP,BCH,BSV,LTC,BNB,EOS,ADA
	}

}