package main;

import java.util.List;

import get_api_data.GetCurrency;
import kong.unirest.json.JSONArray;
<<<<<<< HEAD:cryptocurrencyconsole/src/main/ListInfo.java
=======
import objects.Cryptocurrencies;
>>>>>>> Working:cryptocurrencyconsole/src/main/Main.java
import objects.CurrencyInfo;

public class ListInfo {

	public static void main(String[] args) {

		String userSearch="";
<<<<<<< HEAD:cryptocurrencyconsole/src/main/ListInfo.java
		String interval="";
		JSONArray json = GetCurrency.Currencies(userSearch,interval);
=======
		String interval="1d";
		JSONArray json = GetCurrency.Currencies(userSearch, interval);
		//List<Cryptocurrencies> cryptoMoney=GetCurrency.CurrencyID(json);
>>>>>>> Working:cryptocurrencyconsole/src/main/Main.java
		List<CurrencyInfo> cryptoMoneyInfo=GetCurrency.CurrencyInfo(json);

		
	 for(CurrencyInfo crypto : cryptoMoneyInfo)
			System.out.println(crypto);
		
	System.out.println("end of line");

	//BTC,ETH,USDT,XRP,BCH,BSV,LTC,BNB,EOS,ADA
	}
}