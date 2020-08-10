package testhibernate;

import java.util.Currency;
import java.util.List;

public class ListCurrencies {

	public static void main(String[] args) {
	
		List<Cryptocurrencies> list=CurrencyList.ListCurrency();
		
		for(Cryptocurrencies currency : list) {
			System.out.println(currency);
		}

	}

}
