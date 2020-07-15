package main;

import java.util.List;

import get_api_data.GetCurrency;
import kong.unirest.json.JSONArray;


public class ListInterval {

	public static void main(String[] args) {

		String userSearch="";
		String interval="ytd";
		JSONArray json = GetCurrency.Currencies(userSearch,interval);
		GetCurrency.CurrencyTimeInterval(json, interval);
	//	List<CurrencyInfo> cryptoMoneyInfo=GetCurrency.CurrencyInfo(json);

		
//	 for(CurrencyInfo crypto : cryptoMoneyInfo)
//			System.out.println(crypto);
		
	System.out.println("end of line");


	//BTC,ETH,USDT,XRP,BCH,BSV,LTC,BNB,EOS,ADA
	}
}