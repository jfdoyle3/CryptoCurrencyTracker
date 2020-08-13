package entity.working;

import java.util.List;

import org.hibernate.Session;

import kong.unirest.json.JSONArray;

public class CurrencyInterval7dEntityList {

	public static void main(String[] args) {
		Session session = HibernateCurrencyIntervalFactory.getSessionFactory().openSession();
		session.beginTransaction();
		
		JSONArray json = APIEntity.Currencies("", "7d");
		List<CurrencyInterval> currencyIntervalList = APIEntity.CurrencyTimeInterval(json, "7d");

		for (CurrencyInterval currencyInterval : currencyIntervalList) {
			System.out.println(currencyInterval);
			session.save(currencyInterval);
		}

		session.getTransaction().commit();
		HibernateCurrencyFactory.shutdown();
	}
}