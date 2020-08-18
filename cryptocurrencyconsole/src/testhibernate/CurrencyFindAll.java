package  testhibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;



public class CurrencyFindAll {

	public static void main(String[] args) {
	//	List<Cryptocurrency> currencies=new ArrayList<>();
		SessionFactory factory = new Configuration().configure()
				.addAnnotatedClass(Cryptocurrency.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

;
			
			session.beginTransaction();

			Query<Cryptocurrency> theQuery=session.createQuery("from Cryptocurrency", Cryptocurrency.class);
		
			List<Cryptocurrency> currencies=theQuery.getResultList();
					for(Cryptocurrency currency: currencies) {
			System.out.println("----->   "+currency);
		}
			
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
