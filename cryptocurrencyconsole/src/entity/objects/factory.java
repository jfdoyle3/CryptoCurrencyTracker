package entity.objects;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class factory {
	
	 
	public void getAllCaseLogs() {
		SessionFactory factory = new Configuration()
			 .configure("hibernate.cfg.xml")
			 .addAnnotatedClass(Cryptocurrencies.class)
			 .buildSessionFactory();
	//	List<CaseLog> caseLogs = new ArrayList<CaseLog>();
		// create session
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();
	//		caseLogs = session.createQuery("from CaseLog").getResultList();
		}
		finally {
			session.close();
			factory.close();
		}		
	//	return caseLogs;
}

}
