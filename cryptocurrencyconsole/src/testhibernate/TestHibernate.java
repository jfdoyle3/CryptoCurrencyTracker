package testhibernate;

import java.util.List;

import org.hibernate.Session;

import kong.unirest.json.JSONArray;

public class TestHibernate {

	public static void main(String[] args) {
		Session session = HibernateCurrencyFactory.getSessionFactory().openSession();
		session.beginTransaction();

//		Cryptocurrencies currency = new Cryptocurrencies("WHO", "BTC", "BTC", "Bitcoin",
//				"https://s3.us-east-2.amazonaws.com/nomics-api/static/images/currencies/btc.svg");
//	  session.save(currency);
//		List<CryptocurrenciesEntity> list=CurrencyList.ListCurrency();
		JSONArray json = APIEntity.Currencies("", "7d");
		List<Cryptocurrencies> list = APIEntity.CurrencyID(json);
		
		
		for (Cryptocurrencies currency : list) {
			System.out.println(currency);
			session.save(currency);
		}

		// for (int idx=0; idx<5; idx++) {
		// System.out.println(list.get(idx));
	//	session.save(list.get(idx));
		// }

		session.getTransaction().commit();
		HibernateUtilTemplateNoAnnotations.shutdown();
	}
}