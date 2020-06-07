//package main;
//
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.cfg.Configuration;
//
//import entity.Cryptocurrencies;
//import entity.CurrencyInfo;
//
//public class EntityDBWriteOneTble {
//
//	public static void main(String[] args) {
//
//		// create session factory
//		SessionFactory factory = new Configuration().configure()
//				.addAnnotatedClass(CurrencyInfo.class)
//				.buildSessionFactory();
//
//		// create session
//		Session session = factory.getCurrentSession();
//
//		try {
//
//			CurrencyInfo tmpCurrencyInfo = new CurrencyInfo("564.85130437", "18391300", "21000000", "175910049794", "1", "19345.06577687", "2017-12-16T00:00:00Z");
//
//			// associate the objects
//
//
//			// start a transaction
//			session.beginTransaction();
//
//			// save the instructor
//			// 
//			// Note: this will ALSO save the details object
//			// because of CascadeType.ALL
//			//
//			System.out.println("Saving Currency: " + tmpCurrencyInfo);
//			session.save(tmpCurrencyInfo);
//
//			// commit transaction
//			session.getTransaction().commit();
//			System.out.println("Done!");
//
//		} finally {
// 
//			factory.close();
//		}
//
//	}
//
//}
