package com.cryptocurrency.entity.crud;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.cryptocurrency.entity.factories.HibernateCryptocurrencyFactory;
import com.cryptocurrency.entity.objects.Cryptocurrency;

public class GetAllCurrencies {

//	@SuppressWarnings("unchecked")
//	public static List<Cryptocurrency> getCurrencies() {
//		List<Cryptocurrency> currencies = new ArrayList<Cryptocurrency>();
//		Session session = HibernateCryptocurrencyFactory.getSessionFactory().openSession();
//
//		session.beginTransaction();
//		currencies = session.createQuery("from Cryptocurrency").getResultList();
//
//		session.getTransaction().commit();
//		HibernateCryptocurrencyFactory.shutdown();
//		return currencies;
//	}
	public static List<Cryptocurrency> getCurrencies() {
		List<Cryptocurrency> currencies = new ArrayList<Cryptocurrency>();
	SessionFactory factory = new Configuration().configure()
			.addAnnotatedClass(Cryptocurrency.class)
			.buildSessionFactory();

	Session session = factory.getCurrentSession();

	try {

		session.beginTransaction();

		
		currencies = session.createQuery("from Cryptocurrency").getResultList();
		session.save(currencies);

		session.getTransaction().commit();
		System.out.println("Done!");

	} catch (Exception err) {
		err.printStackTrace();

	} finally {
		session.close();
		factory.close();
	}
	return currencies;

}

}