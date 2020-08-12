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
		Query<Cryptocurrencies> query = session.createQuery(hql);
		List<Cryptocurrencies> listCategories = query.list();
		 
		for (Cryptocurrencies aCategory : listCategories) {
		    System.out.println(aCategory.getName());
		}
		
		session.getTransaction().commit();
		HibernateCurrencyFactory.shutdown();
	}
}

//Cryptocurrencies