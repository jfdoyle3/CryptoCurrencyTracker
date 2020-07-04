package com.cryptocurrency.nomics.main;

import java.util.List;

import com.cryptocurrency.nomics.api.GetCurrency;
import com.cryptocurrency.nomics.objects.Cryptocurrency;

import kong.unirest.json.JSONArray;

public class Main {

	public static void main(String[] args) {

		String userSearch="BTC,ETH,USDT,XRP,BCH,BSV,LTC,BNB,EOS,ADA";
		JSONArray json = GetCurrency.Currencies(userSearch);
		List<Cryptocurrency> cryptoMoney=GetCurrency.CurrencyID(json);
		//GetCurrency.CurrencyInfo(json);
		//GetCurrency.CurrencyInterval(json);
		
	 for(Cryptocurrency crypto : cryptoMoney)
			System.out.println(crypto);
		
	System.out.println("end of line");

	//BTC,ETH,USDT,XRP,BCH,BSV,LTC,BNB,EOS,ADA
	}
}