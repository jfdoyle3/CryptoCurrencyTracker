package main;

import java.util.List;
<<<<<<< HEAD
=======
import java.util.Scanner;
>>>>>>> Working

import get_api_data.GetCurrency;
import kong.unirest.json.JSONArray;
import objects.CurrencyInterval;


public class ListInterval {

	public static void main(String[] args) {
<<<<<<< HEAD

		String userSearch="";
		String interval="1d";
		JSONArray json = GetCurrency.Currencies(userSearch,interval);
	//	GetCurrency.CurrencyTimeInterval(json, interval);
		List<CurrencyInterval> cryptoMoneyInterval=GetCurrency.CurrencyTimeInterval(json, interval);

		
	 for(CurrencyInterval crypto : cryptoMoneyInterval)
			System.out.println(crypto);
		
=======
		String[] interval= {"1d", "ytd"};
		String userSearch="";
		List<>
		for(int idx=0; idx<interval.length; idx++) {
		JSONArray json = GetCurrency.Currencies(userSearch,interval[idx]);
	//	GetCurrency.CurrencyTimeInterval(json, interval);
		List<CurrencyInterval> cryptoMoneyInterval=GetCurrency.CurrencyTimeInterval(json, interval[idx]);
		
		
	 for(CurrencyInterval crypto : cryptoMoneyInterval)
			System.out.println(crypto);
	 
	 Scanner myObj = new Scanner(System.in); 
	    System.out.println("Pause....");

	    String userName = myObj.nextLine();
	    System.out.println(userName);
	    myObj.close();
		}
>>>>>>> Working
	System.out.println("end of line");


	//BTC,ETH,USDT,XRP,BCH,BSV,LTC,BNB,EOS,ADA
	}
}