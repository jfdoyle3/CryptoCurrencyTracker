package com.cryptocurrency.testhibernate;

import org.hibernate.Session;

public class TestHibernate {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();


		Cryptocurrencies currencyEntity = new Cryptocurrencies("TEST", "BTC", "BTC",
		 "Bitcoin","https://s3.us-east-2.amazonaws.com/nomics-api/static/images/currencies/btc.svg");
		
		session.save(currencyEntity);

		// 
		session.getTransaction().commit();
		HibernateUtil.shutdown();
	}
}