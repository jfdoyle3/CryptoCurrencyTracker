package com.cryptocurrency.nomics.main;

import java.util.List;

import com.cryptocurrency.nomics.api.GetCurrency;
import com.cryptocurrency.nomics.objects.CurrencyInfo;

import kong.unirest.json.JSONArray;

public class ListInfo {

	public static void main(String[] args) {

		String userSearch="BTC";
		String interval="1d";
	JSONArray json = GetCurrency.Currencies(userSearch, interval);
		//List<Cryptocurrencies> cryptoMoney=GetCurrency.CurrencyID(json);
		List<CurrencyInfo> cryptoMoneyInfo=GetCurrency.CurrencyInfo(json);
		//GetCurrency.CurrencyInterval(json);
		
	 for(CurrencyInfo crypto : cryptoMoneyInfo)
			System.out.println(crypto);
		
	System.out.println("end of line");

	//BTC,ETH,USDT,XRP,BCH,BSV,LTC,BNB,EOS,ADA
	}
}