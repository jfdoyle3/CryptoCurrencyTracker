package com.cryptocurrency.nomics.main;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.cryptocurrency.nomics.entity.Cryptocurrencies;
import com.cryptocurrency.nomics.entity.CurrencyInfo;
import com.cryptocurrency.nomics.entity.CurrrencyDateStamp;


public class EntityDBWrite {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure()
				.addAnnotatedClass(Cryptocurrencies.class)
				.addAnnotatedClass(CurrencyInfo.class)
				.addAnnotatedClass(CurrrencyDateStamp.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			Cryptocurrencies currency = new Cryptocurrencies("BTC", "BTC", "BTC", "Bitcoin",
					"https://s3.us-east-2.amazonaws.com/nomics-api/static/images/currencies/btc.svg");
			CurrencyInfo currencyInfo = new CurrencyInfo("564.85130437", "18391300", "21000000", "175910049794", "1",
					"19345.06577687", "2017-12-16T00:00:00Z");
			CurrrencyDateStamp interval = new CurrrencyDateStamp("2020-06-01T00:00:00Z", "2020-06-01T14:39:00Z");

			
			currency.setInterval(interval);

			session.beginTransaction();

			System.out.println("||Saving Currency: " + currency);
			System.out.println("||Saving Info: " + currencyInfo);
			System.out.println("||Saving Interval: " + interval);

			session.save(currency);

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
