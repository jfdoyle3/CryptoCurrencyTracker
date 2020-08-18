package com.cryptocurrency.entity.crud;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.cryptocurrency.entity.objects.Cryptocurrency;

public class GetACurrency {

	public static void getACurrency() {
	// List<Cryptocurrency> currencies=new ArrayList<>();
	String currencySymbol = "XRP";
	SessionFactory factory = new Configuration().configure().addAnnotatedClass(Cryptocurrency.class)
			.buildSessionFactory();

	Session session = factory.getCurrentSession();

	try {
		session.beginTransaction();
		String hql = "from Cryptocurrency C where C.symbol=:currency_symbol";
		Query<Cryptocurrency> query = session.createQuery(hql, Cryptocurrency.class);

		query.setParameter("currency_symbol", currencySymbol);
		
		List<Cryptocurrency> currencyList = query.list();
		for (Cryptocurrency currency : currencyList) {
			System.out.println("----->   " + currency);
		}

		session.getTransaction().commit();
		System.out.println("Done!");

	} catch (Exception err) {
		err.printStackTrace();

	} finally {
		session.close();
		factory.close();
	}
	}

}
