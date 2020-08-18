package testhibernate;

import java.util.ArrayList;
import java.util.List;

public class CurrencyListInstantiated {
	
	public static List<Cryptocurrency> ListCurrency(){
	
	List <Cryptocurrency> currencyList=new ArrayList<>();
	
	Cryptocurrency currency1 = new Cryptocurrency("WHO", "BTC", "BTC", "Bitcoin","1",
			"https://s3.us-east-2.amazonaws.com/nomics-api/static/images/currencies/btc.svg");
	Cryptocurrency currency2 = new Cryptocurrency("ZZZ", "BTC", "BTC", "Bitcoin","2",
			"https://s3.us-east-2.amazonaws.com/nomics-api/static/images/currencies/btc.svg");
	Cryptocurrency currency3 = new Cryptocurrency("SDX", "BTC", "BTC", "Bitcoin","3",
			"https://s3.us-east-2.amazonaws.com/nomics-api/static/images/currencies/btc.svg");
	Cryptocurrency currency4 = new Cryptocurrency("BTC", "BTC", "BTC", "Bitcoin","4",
			"https://s3.us-east-2.amazonaws.com/nomics-api/static/images/currencies/btc.svg");
	Cryptocurrency currency5 = new Cryptocurrency("XRP", "BTC", "BTC", "Bitcoin","5",
			"https://s3.us-east-2.amazonaws.com/nomics-api/static/images/currencies/btc.svg");

	currencyList.add(currency1);
	currencyList.add(currency2);
	currencyList.add(currency3);
	currencyList.add(currency4);
	currencyList.add(currency5);
	
	return currencyList;
}
}