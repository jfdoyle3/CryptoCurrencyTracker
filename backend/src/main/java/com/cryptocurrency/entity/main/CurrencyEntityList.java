package com.cryptocurrency.entity.main;

import java.util.List;

import org.hibernate.Session;

import com.cryptocurrency.entity.factories.HibernateCryptocurrencyFactory;
import com.cryptocurrency.entity.objects.CryptocurrencyEntity;
import com.cryptocurrency.nomics.api.GetCurrency;

import kong.unirest.json.JSONArray;

public class CurrencyEntityList {

	public static void main(String[] args) {
		Session session = HibernateCryptocurrencyFactory.getSessionFactory().openSession();
		session.beginTransaction();

		JSONArray json = GetCurrency.Currencies("", "7d");
		List<CryptocurrencyEntity> list = GetCurrency.Cryptocurrency(json);

		for (CryptocurrencyEntity currency : list) {
			System.out.println(currency);
			session.save(currency);
		}

		session.getTransaction().commit();
		HibernateCryptocurrencyFactory.shutdown();
	}
}