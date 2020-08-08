package com.cryptocurrency.entity.main;

import java.util.List;

import com.cryptocurrency.entity.objects.CryptocurrencyEntity;
import com.cryptocurrency.nomics.api.ListCurrencies;
import com.cryptocurrency.nomics.objects.CryptocurrencyHeader;

public class ObjandEnt {

	public static void main(String[] args) {
		String defaultSearch = "";
		List<CryptocurrencyEntity> currencyList = ListCurrencies.CreateCurrencyList(defaultSearch);
			
			for (CryptocurrencyEntity currency : currencyList) {
			System.out.println(currency);
			}

	}

}
