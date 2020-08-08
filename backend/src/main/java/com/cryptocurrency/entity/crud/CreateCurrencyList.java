package com.cryptocurrency.entity.crud;

import java.util.List;

import org.hibernate.Session;


import com.cryptocurrency.entity.objects.CryptocurrencyEntity;
import com.cryptocurrency.nomics.api.ListCurrencies;
import com.cryptocurrency.nomics.objects.CryptocurrencyHeader;

public class CreateCurrencyList {

	
	public static void main(String[] args) {
		String defaultSearch = "";
	List<CryptocurrencyHeader> currencyList = ListCurrencies.CreateCurrencyList(defaultSearch);
		Session session = HibernateCurrencyFactory.getSessionFactory().openSession();
		session.beginTransaction();
		for (CryptocurrencyHeader currency : currencyList) {
		session.save(currency);
		}
	
		session.getTransaction().commit();
		HibernateCurrencyFactory.shutdown();
	}
}