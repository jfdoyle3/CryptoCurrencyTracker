package com.cryptocurrency.nomics.main;

import java.util.ArrayList;
import java.util.List;

import com.cryptocurrency.nomics.api.GetCurrency;
import com.cryptocurrency.nomics.objects.CryptocurrencyHeader;
import com.cryptocurrency.nomics.objects.CurrencyInfo;

import kong.unirest.json.JSONArray;

public class Main {

	public static void main(String[] args) {
<<<<<<< HEAD

<<<<<<< HEAD
	//	List<Cryptocurrency> topTen=new ArrayList<>();
		List<CurrencyInfo> moneyInfo=new ArrayList<>();
		String userSearch="";
	//	JSONArray json = GetCurrency.Currencies(userSearch,interval);
		// List<Cryptocurrency> cryptoMoney=GetCurrency.CurrencyID(json);
	//	List<CurrencyInfo> cryptoMoneyInfo=GetCurrency.CurrencyInfo(json);
	//	GetCurrency.CurrencyInterval(json);
		
//	 for(CurrencyInfo crypto : cryptoMoneyInfo) {
//			System.out.println(crypto);
			
//	 }
	//
	System.out.println("end of line");
=======
		// List<Cryptocurrency> topTen=new ArrayList<>();
		List<CurrencyInfo> moneyInfo = new ArrayList<>();
		String userSearch = "BTC";
		String interval = "1d";
		JSONArray json = GetCurrency.Currencies(userSearch, interval);
		// List<Cryptocurrency> cryptoMoney=GetCurrency.CurrencyID(json);
		List<CurrencyInfo> cryptoMoneyInfo = GetCurrency.CurrencyInfo(json);
		// GetCurrency.CurrencyInterval(json);

		for (CurrencyInfo crypto : cryptoMoneyInfo) {
			System.out.println(crypto);
>>>>>>> Working

		}

		System.out.println("end of line");
=======
		
		   System.out.println("Hello \u001b[1;31mred\u001b[0m world!");

//		// List<Cryptocurrency> topTen=new ArrayList<>();
//		List<CurrencyInfo> moneyInfo = new ArrayList<>();
//		String userSearch = "BTC";
//		String interval = "1d";
//		JSONArray json = GetCurrency.Currencies(userSearch, interval);
//		// List<Cryptocurrency> cryptoMoney=GetCurrency.CurrencyID(json);
//		List<CurrencyInfo> cryptoMoneyInfo = GetCurrency.CurrencyInfo(json);
//		// GetCurrency.CurrencyInterval(json);
//
//		for (CurrencyInfo crypto : cryptoMoneyInfo) {
//			System.out.println(crypto);
//
//		}
//
//		System.out.println("end of line");
>>>>>>> Working

		// BTC,ETH,USDT,XRP,BCH,BSV,LTC,BNB,EOS,ADA
	}
}