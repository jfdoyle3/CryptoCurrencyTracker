package testhibernate;

import java.util.ArrayList;
import java.util.List;

public class CurrencyList {
	
	public static List<Cryptocurrencies> ListCurrency(){
	
	List <Cryptocurrencies> currencyList=new ArrayList<>();
	
	Cryptocurrencies currency1 = new Cryptocurrencies("WHO", "BTC", "BTC", "Bitcoin",
			"https://s3.us-east-2.amazonaws.com/nomics-api/static/images/currencies/btc.svg");
	Cryptocurrencies currency2 = new Cryptocurrencies("WHO", "BTC", "BTC", "Bitcoin",
			"https://s3.us-east-2.amazonaws.com/nomics-api/static/images/currencies/btc.svg");
	Cryptocurrencies currency3 = new Cryptocurrencies("WHO", "BTC", "BTC", "Bitcoin",
			"https://s3.us-east-2.amazonaws.com/nomics-api/static/images/currencies/btc.svg");
	Cryptocurrencies currency4 = new Cryptocurrencies("WHO", "BTC", "BTC", "Bitcoin",
			"https://s3.us-east-2.amazonaws.com/nomics-api/static/images/currencies/btc.svg");
	Cryptocurrencies currency5 = new Cryptocurrencies("WHO", "BTC", "BTC", "Bitcoin",
			"https://s3.us-east-2.amazonaws.com/nomics-api/static/images/currencies/btc.svg");

	currencyList.add(currency1);
	currencyList.add(currency2);
	currencyList.add(currency3);
	currencyList.add(currency4);
	currencyList.add(currency5);
	
	return currencyList;
}
}