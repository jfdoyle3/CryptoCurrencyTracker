package com.cryptocurrency.backend.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cryptocurrency.entity.objects.CurrencyDailyPrice;
import com.cryptocurrency.nomics.objects.CurrencyInfo;

@Service
public class CurrencyDailyPriceServices {

	// private String defaultSearch="BTC,ETH,USDT,XRP,BCH,BSV,LTC,BNB,EOS,ADA";
//	private String defaultSearch = "";
//	private List<CurrencyDailyPrice> currencyDailyPriceList = ListCurrenciesInfo.CreateCurrencyListInfo(defaultSearch);
//	private int idCounter = 0;

	// Show All currencies in List
//	public List<CurrencyInfo> findAll() {
//		return currencyInfoList;
//	}

//	public List<CurrencyInfo> listTopTen() {
//		List<CurrencyInfo> topTenList = new ArrayList<>();
//		for (int idx = 0; idx < 10; idx++) {
//			topTenList.add(currencyList.get(idx));
//		}
//
//		return topTenList;
//
//	}

	// Find A Currency in the List
//	public CurrencyDailyPrice findById(int id) {
//		for (CurrencyDailyPrice currencyInfo : currencyInfoList) {
//			if (currencyInfo.getId() == id) {
//			//	System.out.println(currency);
//				return currencyInfo;
//			}
//
//		}
//		return null;
//	}

	// Get any known Currency in the API

//	public CurrencyInfo findByAnyCurrency(String currencySearch) {
//		String currencySymbol = currencySearch.toUpperCase();
//		for (CurrencyInfo currency : currencyInfoList) {
//			if (currency.getSymbol().equals(currencySymbol)) {
//				return currency;

//	public CurrencyDailyPrice findBySymbol(String currencySearch) {
//		String currencySymbol = currencySearch.toUpperCase();
//		for (CurrencyDailyPrice currencyInfo : currencyInfoList) {
//			if (currencyInfo.getSymbol().equals(currencySymbol) ) {
//				return currencyInfo;
//
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
