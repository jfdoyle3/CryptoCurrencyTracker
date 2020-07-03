package main;

import java.util.List;

import Objects.Cryptocurrencies;
import get_api_data.GetCurrency;
import kong.unirest.json.JSONArray;

public class Main {

	public static void main(String[] args) {

		String userSearch="BTC";
		JSONArray json = GetCurrency.Currencies(userSearch);
		List<Cryptocurrencies> cryptoMoney=GetCurrency.CurrencyID(json);
		//GetCurrency.CurrencyInfo(json);
		//GetCurrency.CurrencyInterval(json);
		
	 for(Cryptocurrencies crypto : cryptoMoney)
			System.out.println(crypto);
		
	System.out.println("end of line");

	//BTC,ETH,USDT,XRP,BCH,BSV,LTC,BNB,EOS,ADA
	}
}