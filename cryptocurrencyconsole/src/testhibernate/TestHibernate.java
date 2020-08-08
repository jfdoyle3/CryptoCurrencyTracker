package testhibernate;

import org.hibernate.Session;

public class TestHibernate {

	public static void main(String[] args) {
		Session session = HibernateCurrencyFactory.getSessionFactory().openSession();
		session.beginTransaction();

		Cryptocurrencies currency = new Cryptocurrencies("WHO", "BTC", "BTC", "Bitcoin",
				"https://s3.us-east-2.amazonaws.com/nomics-api/static/images/currencies/btc.svg");

		session.save(currency);

	
		session.getTransaction().commit();
		HibernateUtilTemplateNoAnnotations.shutdown();
	}
}