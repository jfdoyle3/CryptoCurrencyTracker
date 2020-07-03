package com.cryptocurrency.backend.services;

import java.util.List;

import com.cryptocurrency.nomics.api.GetCurrency;
import com.cryptocurrency.nomics.objects.Cryptocurrency;

import kong.unirest.json.JSONArray;

public class CurrencyServices {
	 
	
	private String userSearch="BTC,ETH,USDT,XRP,BCH,BSV,LTC,BNB,EOS,ADA";
	private JSONArray json = GetCurrency.Currencies(userSearch);
	private List<Cryptocurrency> cryptoMoney=GetCurrency.CurrencyID(json);
	
	
	public List<Cryptocurrency> findAll() {
		return cryptoMoney;
	
	}
	

}
