package main;

import java.util.List;

import Objects.Cryptocurrencies;
import Objects.CurrencyInfo;
import get_api_data.GetCurrency;
import kong.unirest.json.JSONArray;

public class Main {

	public static void main(String[] args) {

		String userSearch="";
		JSONArray json = GetCurrency.Currencies(userSearch);
		//List<Cryptocurrencies> cryptoMoney=GetCurrency.CurrencyID(json);
		List<CurrencyInfo> cryptoMoneyInfo=GetCurrency.CurrencyInfo(json);
		//GetCurrency.CurrencyInterval(json);
		
	 for(CurrencyInfo crypto : cryptoMoneyInfo)
			System.out.println(crypto);
		
	System.out.println("end of line");

	//BTC,ETH,USDT,XRP,BCH,BSV,LTC,BNB,EOS,ADA
	}
}