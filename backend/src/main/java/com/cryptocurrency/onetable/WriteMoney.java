package com.cryptocurrency.onetable;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import kong.unirest.json.JSONArray;


public class WriteMoney {

	public static void main(String[] args) {


		SessionFactory factory = new Configuration().configure()
				.addAnnotatedClass(Cryptomoney.class)
				.buildSessionFactory();


	Session session = factory.getCurrentSession();

		try {
			
			
			JSONArray json = GetMoney.Currency("BTC,ETH,USDT,XRP,BCH,BSV,LTC,BNB,EOS,ADA");
			GetMoney m=new GetMoney();
			ArrayList<Cryptomoney> monies=m.money(json);
			 
			// System.out.println("||"+monies.get(1));

			session.beginTransaction();
			for (int idx=0; idx<monies.size(); idx++) {

		//System.out.println("Saving Currency: " + );
		session.save(monies.get(idx));

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

