package com.cryptocurrency.backend.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cryptocurrency.entity.crud.CurrencyTopFive;
import com.cryptocurrency.entity.crud.CurrencyAllRecords;
import com.cryptocurrency.entity.objects.Cryptocurrency;

@Service
public class CryptocurrencyServices {

	// private String defaultSearch="BTC,ETH,USDT,XRP,BCH,BSV,LTC,BNB,EOS,ADA";
	private String defaultSearch = "";
//	private List<Cryptocurrency> currencyList = ListCurrencies.CreateCurrencyList(defaultSearch);
	
	// Show All currencies in List
	public List<Cryptocurrency> findAll() {
		List<Cryptocurrency> all=CurrencyAllRecords.AllCurrencies();
		return all;
	}
//	public List<Cryptocurrency> listTopFive() {
//		List<Cryptocurrency> topFiveList = new ArrayList<>();
//		for (int idx = 0; idx < 5; idx++) {
//			topFiveList.add(currencyList.get(idx));
//		}
//
//		return topFiveList;
//
//}
	
	public List<Cryptocurrency> listTopFive() {
		List<Cryptocurrency> topFive=CurrencyTopFive.TopFiveList();
		return topFive;

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
//	public CryptocurrencyHeader findByCurrencyBySymbol(String currencySearch) {
//		String currencySymbol = currencySearch.toUpperCase();
//		for (CryptocurrencyHeader currency : currencyList) {
//			if (currency.getSymbol().equals(currencySymbol)) {
//				return currency;
//			}
//		}
//		return null;
//	}

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
