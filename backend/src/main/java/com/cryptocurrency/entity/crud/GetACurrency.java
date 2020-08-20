package com.cryptocurrency.entity.crud;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.cryptocurrency.entity.objects.Cryptocurrency;

public class GetACurrency {

	public static Cryptocurrency getACurrency() {
	//	Cryptocurrency currencyList = null;
//	 List<Cryptocurrency> currencies=new ArrayList<>();
	String currencySymbol = "XRP";
	SessionFactory factory = new Configuration().configure().addAnnotatedClass(Cryptocurrency.class)
			.buildSessionFactory();

	Session session = factory.getCurrentSession();

	try {
		session.beginTransaction();
		String hql = "from Cryptocurrency C where C.symbol=:currency_symbol";
		Query<Cryptocurrency> query = session.createQuery(hql, Cryptocurrency.class);

		query.setParameter("currency_symbol", currencySymbol);
		
		Cryptocurrency currencyList = query.getSingleResult();
//		for (Cryptocurrency currency : currencyList) {
			System.out.println("sf:->   " + currencyList);
//			currencies.add(currency);
//		}

		session.getTransaction().commit();
		System.out.println("Done!");

	} catch (Exception err) {
		err.printStackTrace();

	} finally {
		session.close();
		factory.close();
	}
	Cryptocurrency staticCurrency = new Cryptocurrency("TST", "BTC", "TST", "Bitcoin","1",
			"https://s3.us-east-2.amazonaws.com/nomics-api/static/images/currencies/btc.svg");
	return staticCurrency;
	}

}
