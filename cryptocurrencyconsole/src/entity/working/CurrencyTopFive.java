package entity.working;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import kong.unirest.json.JSONArray;

public class CurrencyTopFive {

	public static void main(String[] args) {
		Session session = HibernateCurrencyFactory.getSessionFactory().openSession();
		session.beginTransaction();

		String hql = "from Cryptocurrencies";
		Query<CryptocurrencyEntity> query = session.createQuery(hql);
		List<CryptocurrencyEntity> listCategories = query.list();
		 
		for (int idx=0; idx<5; idx++) {
			 System.out.println(listCategories.get(idx));
		}
//		for (Cryptocurrencies aCategory : listCategories) {
//		    System.out.println(aCategory);
//		}
		
		session.getTransaction().commit();
		HibernateCurrencyFactory.shutdown();
	}
}

//Cryptocurrencies