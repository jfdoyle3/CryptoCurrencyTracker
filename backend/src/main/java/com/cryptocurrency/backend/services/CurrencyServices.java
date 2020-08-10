package com.cryptocurrency.backend.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.cryptocurrency.nomics.api.ListCurrencies;
import com.cryptocurrency.nomics.objects.CryptocurrencyHeader;

@Service
public class CurrencyServices {

	// private String defaultSearch="BTC,ETH,USDT,XRP,BCH,BSV,LTC,BNB,EOS,ADA";
	private String defaultSearch = "";
	private List<CryptocurrencyHeader> currencyList = ListCurrencies.CreateCurrencyList(defaultSearch);
	private int idCounter = 0;

	// Show All currencies in List
	public List<CryptocurrencyHeader> findAll() {
		return currencyList;
	}

	public List<CryptocurrencyHeader> listTopFive() {
		List<CryptocurrencyHeader> topTenList = new ArrayList<>();
		for (int idx = 0; idx < 5; idx++) {
			topTenList.add(currencyList.get(idx));
		}

		return topTenList;

	}

	// Find A Currency in the List
//	public CryptocurrencyHeader findById(long id) {
//		for (CryptocurrencyHeader currency : currencyList) {
//			if (currency.getId() == id) {
//			//	System.out.println(currency);
//				return currency;
//			}
//
//		}
//		return null;
//	}

	// Get Currency Symbol in the API
	public CryptocurrencyHeader findByCurrencyBySymbol(String currencySearch) {
		String currencySymbol = currencySearch.toUpperCase();
		for (CryptocurrencyHeader currency : currencyList) {
			if (currency.getSymbol().equals(currencySymbol)) {
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
