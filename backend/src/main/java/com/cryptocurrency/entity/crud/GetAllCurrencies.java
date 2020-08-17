package com.cryptocurrency.entity.crud;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.cryptocurrency.entity.factories.HibernateCryptocurrencyFactory;
import com.cryptocurrency.entity.objects.Cryptocurrency;

public class GetAllCurrencies {

	@SuppressWarnings("unchecked")
	public static List<Cryptocurrency> getCurrencies() {
		List<Cryptocurrency> currencies = new ArrayList<Cryptocurrency>();
		Session session = HibernateCryptocurrencyFactory.getSessionFactory().openSession();

		session.beginTransaction();
		currencies = session.createQuery("from Cryptocurrency").getResultList();

		session.getTransaction().commit();
		HibernateCryptocurrencyFactory.shutdown();
		return currencies;
	}

}