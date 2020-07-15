package main;

import java.util.List;

import get_api_data.GetCurrency;
import kong.unirest.json.JSONArray;
import objects.CurrencyInterval;


public class ListInterval {

	public static void main(String[] args) {

		String userSearch="";
		String interval="1d";
		JSONArray json = GetCurrency.Currencies(userSearch,interval);
	//	GetCurrency.CurrencyTimeInterval(json, interval);
		List<CurrencyInterval> cryptoMoneyInterval=GetCurrency.CurrencyTimeInterval(json, interval);

		
	 for(CurrencyInterval crypto : cryptoMoneyInterval)
			System.out.println(crypto);
		
	System.out.println("end of line");


	//BTC,ETH,USDT,XRP,BCH,BSV,LTC,BNB,EOS,ADA
	}
}