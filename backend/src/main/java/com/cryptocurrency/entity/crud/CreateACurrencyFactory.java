package  com.cryptocurrency.entity.crud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.cryptocurrency.entity.objects.Cryptocurrency;

public class CreateACurrencyFactory {

	public static void CreateACurrencyRecord() {

		SessionFactory factory = new Configuration().configure()
				.addAnnotatedClass(Cryptocurrency.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			Cryptocurrency currency = new Cryptocurrency("ZXY", "BTC", "BTC", "Bitcoin","1",
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
