package main;


import java.util.List;

import get_api_data.GetCurrency;
import kong.unirest.json.JSONArray;
import objects.Cryptocurrencies;

public class ListHeaders {

	public static void main(String[] args) {

		String userSearch="";
		String interval="";
		JSONArray json = GetCurrency.Currencies(userSearch,interval);
		List<Cryptocurrencies> cryptoMoney=GetCurrency.CurrencyID(json);
		
	 for(Cryptocurrencies crypto : cryptoMoney)
			System.out.println(crypto);
		
	System.out.println("end of line");

	//BTC,ETH,USDT,XRP,BCH,BSV,LTC,BNB,EOS,ADA
	}
}