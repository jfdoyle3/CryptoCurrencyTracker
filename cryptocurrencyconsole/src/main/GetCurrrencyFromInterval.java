package main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.Cryptocurrencies;
import entity.CurrencyInfo;
import entity.Interval;


public class GetCurrrencyFromInterval {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure()
				.addAnnotatedClass(Cryptocurrencies.class)
				.addAnnotatedClass(CurrencyInfo.class)
				.addAnnotatedClass(Interval.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

		

			session.beginTransaction();

			int theId = 1;
			Cryptocurrencies cryptoCurrency = session.get(Cryptocurrencies.class, theId);
			
			System.out.println("||Currency: "+ cryptoCurrency);
			// get course for the instructor
			System.out.println("||Interval: "+cryptoCurrency.getInterval());

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
























