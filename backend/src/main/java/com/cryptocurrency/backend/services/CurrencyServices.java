package com.cryptocurrency.backend.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.cryptocurrency.nomics.api.ListCurrencies;
import com.cryptocurrency.nomics.objects.Cryptocurrency;

@Service
public class CurrencyServices {

	// private String defaultSearch="BTC,ETH,USDT,XRP,BCH,BSV,LTC,BNB,EOS,ADA";
	private String defaultSearch = "";
	private List<Cryptocurrency> currencyList = ListCurrencies.CreateCurrencyList(defaultSearch);
	private long idCounter = 0;

	// Show All currencies in List
	public List<Cryptocurrency> findAll() {
		return currencyList;
	}

	public List<Cryptocurrency> listTopTen() {
		List<Cryptocurrency> topTenList = new ArrayList<>();
		for (int idx = 0; idx < 10; idx++) {
			topTenList.add(currencyList.get(idx));
		}

		return topTenList;

	}

	// Find A Currency in the List
	public Cryptocurrency findById(long id) {
		for (Cryptocurrency currency : currencyList) {
			if (currency.getId() == id) {
				System.out.println(currency);
				return currency;
			}

		}
		return null;
	}

	// Get any known Currency in the API
	public Cryptocurrency findByAnyCurrency(String currencySearch) {
		String currencySymbol = currencySearch.toUpperCase();
		String currencyName = currencySearch.substring(0, 1).toUpperCase() + currencySearch.substring(1);
		for (Cryptocurrency currency : currencyList) {
			if (currency.getCurrencyId().equals(currencySymbol) || currency.getName().equals(currencyName)) {
				return currency;
			}
		}
		return null;
	}

	// Delete by Id
//	public Cryptocurrency deleteById(long id) {
//		Cryptocurrency currency = findById(id);
//		if (currency==null) return null;
//		if(currencyList.remove(currency)) {
//		return currency;
//		}
//		return null;
//	}

	// Save / Update
//	public Cryptocurrency save(Cryptocurrency cryptoCurrency) {
//		if (cryptoCurrency.getId()==-1 || cryptoCurrency.getId()==0) {
//			cryptoCurrency.setId(++idCounter);
//			currencyList.add(cryptoCurrency);
//		}else {
//			deleteById(cryptoCurrency.getCurrencyId());
//			currencyList.add(cryptoCurrency);
//		}
//		return cryptoCurrency;
//	}

}
