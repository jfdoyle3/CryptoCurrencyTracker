package main;

import get_api_data.GetCurrency;
import kong.unirest.json.JSONArray;

public class Main {

	public static void main(String[] args) {


		JSONArray json = GetCurrency.Currencies("BTC,ETH,USDT,XRP,BCH,BSV,LTC,BNB,EOS,ADA");
		GetCurrency.CurrencyID(json);
	    GetCurrency.CurrencyInfo(json);
		GetCurrency.CurrencyInterval(json);
//		
//	System.out.println("end of line");
//BTC,ETH,USDT,XRP,BCH,BSV,LTC,BNB,EOS,ADA
	}

}