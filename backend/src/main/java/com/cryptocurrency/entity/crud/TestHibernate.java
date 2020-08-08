package com.cryptocurrency.entity.crud;

import org.hibernate.Session;


import com.cryptocurrency.entity.objects.CryptocurrencyEntity;

public class TestHibernate {

	public static void main(String[] args) {
		Session session = HibernateCurrencyFactory.getSessionFactory().openSession();
		session.beginTransaction();

		CryptocurrencyEntity currency = new CryptocurrencyEntity("BOO", "BTC", "BTC", "Bitcoin","1",
				"https://s3.us-east-2.amazonaws.com/nomics-api/static/images/currencies/btc.svg");

		session.save(currency);

	
		session.getTransaction().commit();
		HibernateCurrencyFactory.shutdown();
	}
}