package com.cryptocurrency.entity.main;

import java.util.List;

import org.hibernate.Session;

import com.cryptocurrency.backend.payload.nomics.api.GetCurrency;
import com.cryptocurrency.entity.factories.HibernateCryptocurrencyFactory;
import com.cryptocurrency.entity.objects.Cryptocurrency;

import kong.unirest.json.JSONArray;

public class CreateCurrencyTableList {

	public static void main(String[] args) {
		Session session = HibernateCryptocurrencyFactory.getSessionFactory().openSession();
		session.beginTransaction();

		JSONArray json = GetCurrency.Currencies("", "7d");
		List<Cryptocurrency> list = GetCurrency.Cryptocurrency(json);

		for (Cryptocurrency currency : list) {
			System.out.println(currency);
			session.save(currency);
		}

		session.getTransaction().commit();
		HibernateCryptocurrencyFactory.shutdown();
	}
}