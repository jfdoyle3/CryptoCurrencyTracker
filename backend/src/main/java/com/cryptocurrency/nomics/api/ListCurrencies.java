package com.cryptocurrency.nomics.api;

import java.util.ArrayList;
import java.util.List;

import com.cryptocurrency.nomics.objects.Cryptocurrency;

import kong.unirest.json.JSONArray;

public class ListCurrencies {

	public static List<Cryptocurrency> CreateCurrencyList(String userSearch){
	
	JSONArray json = GetCurrency.Currencies(userSearch);
	List<Cryptocurrency> cryptoMoney=GetCurrency.CurrencyID(json);
	
	return cryptoMoney;
	
	}
	
	public static void topTenCurrencies(){
		List<Cryptocurrency> topTen=new ArrayList<>();
		JSONArray json = GetCurrency.Currencies(userSearch);
		List<Cryptocurrency> cryptoMoney=GetCurrency.CurrencyID(json);
		
	//	return cryptoMoney;
		
		}
}
