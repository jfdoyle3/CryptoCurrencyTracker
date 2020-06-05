package main;

import database.DBConnection;
import get_api_data.GetCurrency;


public class Main {

	public static void main(String[] args) {

	//	DBConnection.connectDB();
		
		GetCurrency.Currencies("BTC,ETH");

		
//BTC,ETH,USDT,XRP,BCH,BSV,LTC,BNB,EOS,ADA
	}

}