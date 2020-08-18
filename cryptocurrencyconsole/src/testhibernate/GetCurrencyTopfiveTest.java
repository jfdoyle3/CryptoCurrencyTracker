package  testhibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;



public class GetCurrencyTopfiveTest {

	public static void main(String[] args) {
	//	List<Cryptocurrency> currencies=new ArrayList<>();
		SessionFactory factory = new Configuration().configure()
				.addAnnotatedClass(Cryptocurrency.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {
			session.beginTransaction();
			  Query<Cryptocurrency> query = session.createQuery("from Cryptocurrency", Cryptocurrency.class);

		 
		        query.setFirstResult(0);
		        query.setMaxResults(5);

		        List<Cryptocurrency> labels = query.list();
					for(Cryptocurrency currency : labels) {
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
