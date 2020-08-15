package com.cryptocurrency.entity.main;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.cryptocurrency.entity.factories.HibernateCryptocurrencyFactory;
import com.cryptocurrency.entity.objects.Cryptocurrency;

public class CurrencyAllRecords {

	public static void main(String[] args) {
		Session session = HibernateCryptocurrencyFactory .getSessionFactory().openSession();
		session.beginTransaction();

		String hql = "from Cryptocurrency";
		Query<Cryptocurrency> query = session.createQuery(hql);
		List<Cryptocurrency> listCurrencies = query.list();
		  
		for(Cryptocurrency currency : listCurrencies) {
			System.out.println(currency);
		}
		
		session.getTransaction().commit();
		HibernateCryptocurrencyFactory .shutdown();
	}
}