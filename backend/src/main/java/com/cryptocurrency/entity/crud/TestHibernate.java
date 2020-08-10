package com.cryptocurrency.entity.crud;

import java.util.List;

import org.hibernate.Session;


import com.cryptocurrency.entity.objects.CryptocurrencyEntity;
import com.cryptocurrency.nomics.api.ListCurrencies;
import com.cryptocurrency.nomics.objects.CryptocurrencyHeader;

public class TestHibernate {

	public static void main(String[] args) {
		Session session = HibernateCurrencyFactory.getSessionFactory().openSession();
		session.beginTransaction();

		String defaultSearch = "XRP";
		List<CryptocurrencyHeader> currencyList = ListCurrencies.CreateCurrencyList(defaultSearch);
			
			for (CryptocurrencyHeader currency : currencyList) {
			System.out.println(currency);
			session.save(currency);
			
			}
			
	
		session.getTransaction().commit();
		HibernateCurrencyFactory.shutdown();
	}
}