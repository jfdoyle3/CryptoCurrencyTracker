package com.cryptocurrency.backend.utils;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.cryptocurrency.backend.payloads.response.cryptocurrency.CurrencyDailyPrice;

public class CheckDateStamp {

	private static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'");  
	private static LocalDateTime now = LocalDateTime.now();
	private static String strNow=dtf.format(now).toString();

	public static boolean checkDateStamp(List<CurrencyDailyPrice> prices) {
		boolean results = true;
		return results;
	}

	public static void displayDateStamp(List<CurrencyDailyPrice> prices) throws ParseException {
		System.out.println("====>CL: TimeStamp: " + prices.get(0).getPriceTimeStamp());
		System.out.println("====>CL: JAVAStamp: "+strNow);
		System.out.println("==> T/F: "+(prices.get(0).getPriceTimeStamp().equals(strNow) ? "true":"false"));
		long nowEpochTime= DateTimeUtils2.dateToEpochTime(strNow);
		long timeStampEpochTime=DateTimeUtils2.dateToEpochTime(prices.get(0).getPriceTimeStamp());
		long timeDifference=timeStampEpochTime-nowEpochTime;
		
		System.out.println("DateTime Utils:");
		System.out.println("====>TimeStamp: "+timeStampEpochTime);
		System.out.println("====>Now: "+nowEpochTime);
		System.out.println("====>Time Difference: "+timeDifference);
		
	}
}
