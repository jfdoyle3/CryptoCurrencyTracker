package main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.Cryptocurrencies;
import entity.CurrencyInfo;

public class EntityDBWrite {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure()
				.addAnnotatedClass(Cryptocurrencies.class)
				.addAnnotatedClass(CurrencyInfo.class)
			//	.addAnnotatedClass(Intervals.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {

			Cryptocurrencies currency = new Cryptocurrencies("BTC", "BTC", "BTC", "Bitcoin", "https://s3.us-east-2.amazonaws.com/nomics-api/static/images/currencies/btc.svg");
			CurrencyInfo currencyInfo = new CurrencyInfo("564.85130437", "18391300", "21000000", "175910049794", "1", "19345.06577687", "2017-12-16T00:00:00Z");
		//	Intervals interval=new Intervals("2020-06-01T00:00:00Z","2020-06-01T14:39:00Z");
			// associate the objects
	        currency.setCurrencyInfo(currencyInfo);
	        

			// start a transaction
			session.beginTransaction();

			// save the instructor
			// 
			// Note: this will ALSO save the details object
			// because of CascadeType.ALL
			//
			System.out.println("Saving Currency: " + currency);
			session.save(currency);

			// commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");

		} finally {
 
			factory.close();
		}

	}

}
