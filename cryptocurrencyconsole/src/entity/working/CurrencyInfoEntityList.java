package entity.working;

import java.util.List;

import org.hibernate.Session;

import kong.unirest.json.JSONArray;

public class CurrencyInfoEntityList {

	public static void main(String[] args) {
		Session session = HibernateCurrencyInfoFactory.getSessionFactory().openSession();
		session.beginTransaction();

		JSONArray json = APIEntity.Currencies("", "7d");
		List<CurrencyInfo> currencyInfoList = APIEntity.CurrencyInfo(json);

		for (CurrencyInfo currencyInfo : currencyInfoList) {
			System.out.println(currencyInfo);
			session.save(currencyInfo);
		}

		session.getTransaction().commit();
		HibernateCurrencyFactory.shutdown();
	}
}