package com.cryptocurrency.entity.crud;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.cryptocurrency.entity.factories.HibernateCryptocurrencyFactory;
import com.cryptocurrency.entity.objects.Cryptocurrency;

public class CurrencyAllRecords {

	public  static List<Cryptocurrency> AllCurrencies() {
		Session session = HibernateCryptocurrencyFactory .getSessionFactory().openSession();
		
List<Cryptocurrency> currencies = new ArrayList<Cryptocurrency>();
		
		
			session.beginTransaction();
			currencies= session.createQuery("from Cryptocurrency").getResultList();
	
		
		session.getTransaction().commit();
		HibernateCryptocurrencyFactory .shutdown();
	return currencies;
	}
	
}