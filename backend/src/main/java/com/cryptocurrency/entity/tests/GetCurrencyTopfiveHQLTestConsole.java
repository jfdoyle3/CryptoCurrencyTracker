package  com.cryptocurrency.entity.tests;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.cryptocurrency.entity.objects.Cryptocurrency;



public class GetCurrencyTopfiveHQLTestConsole {

	public static void main(String[] args) {
		List<Cryptocurrency> currencies=new ArrayList<>();
		SessionFactory factory = new Configuration().configure()
				.addAnnotatedClass(Cryptocurrency.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {
			session.beginTransaction();
			  Query<Cryptocurrency> query = session.createQuery("FROM Cryptocurrency C WHERE C.ranking<6 ORDER BY C.ranking DESC");
		 


		        List<Cryptocurrency> labels = query.list();
					for(Cryptocurrency currency : labels) {
			System.out.println("sf:->   "+currency);
			currencies.add(currency);
		}
			
			session.getTransaction().commit();
			System.out.println("Session committed!");

		} catch (Exception err) {
			err.printStackTrace();

		} finally {
			session.close();
			factory.close();
		}
		for(Cryptocurrency currency : currencies) {
			System.out.println("currencies List: -->   "+currency);
		}
		System.out.println("\n\nend of line");
	}

}
