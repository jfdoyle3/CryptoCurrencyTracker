package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import get_api_data.GetCurrency;
import kong.unirest.json.JSONArray;
import objects.CurrencyInterval;


public class ListInterval {

	public static void main(String[] args) {
<<<<<<< HEAD
<<<<<<< HEAD

		String[] interval= {"1d","7d", "ytd"};
		String userSearch="BTC ";
=======
		String[] interval= {"1d"};
		
		String userSearch="";
>>>>>>> Working
		List<List<CurrencyInterval>> intervalsList=new ArrayList<>();

		for(int idx=0; idx<interval.length; idx++) {
		JSONArray json = GetCurrency.Currencies(userSearch,interval[idx]);
=======
		String[] interval= {"7d","30d","ytd"};
		
		String symbol="ETH";
	
	for(int idx=0; idx<interval.length; idx++) {
		JSONArray json = GetCurrency.Currencies(symbol,interval[idx]);
>>>>>>> Working
	//	GetCurrency.CurrencyTimeInterval(json, interval);
		List<CurrencyInterval> cryptoMoneyInterval=GetCurrency.CurrencyTimeInterval(json, interval[idx]);
		System.out.println(cryptoMoneyInterval.get(0));
		
//	 for(CurrencyInterval crypto : cryptoMoneyInterval)
//			System.out.println(crypto);
	 
//	 Scanner myObj = new Scanner(System.in); 
//	    System.out.println("Pause....");
//
//	    String userName = myObj.nextLine();
//	    System.out.println(userName);
//	    myObj.close();
		}

	System.out.println("end of line");

		}
	//BTC,ETH,USDT,XRP,BCH,BSV,LTC,BNB,EOS,ADA
//	}
}