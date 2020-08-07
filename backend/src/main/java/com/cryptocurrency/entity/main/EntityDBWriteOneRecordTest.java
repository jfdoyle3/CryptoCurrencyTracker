package  com.cryptocurrency.entity.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.cryptocurrency.entity.objects.Cryptocurrencies;

public class EntityDBWriteOneRecordTest {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure()
				.addAnnotatedClass(Cryptocurrencies.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			Cryptocurrencies currency = new Cryptocurrencies("XRP", "BTC", "BTC", "Bitcoin",
					"https://s3.us-east-2.amazonaws.com/nomics-api/static/images/currencies/btc.svg");

			session.beginTransaction();

			System.out.println("||Saving Currency: " + currency);

			session.save(currency);

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
