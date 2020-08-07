package com.cryptocurrency.testhibernate;

import org.hibernate.Session;

public class TestHibernate {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		// Add new Employee object
		// EmployeeEntity emp = new EmployeeEntity();
		Cryptocurrencies currencyEntity = new Cryptocurrencies();
		currencyEntity.setSymbol("BTC");
		session.save(currencyEntity);

		// "XRP", "BTC", "BTC",
		// "Bitcoin","https://s3.us-east-2.amazonaws.com/nomics-api/static/images/currencies/btc.svg"

		session.getTransaction().commit();
		HibernateUtil.shutdown();
	}
}