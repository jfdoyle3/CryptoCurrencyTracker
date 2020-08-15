package com.cryptocurrency.entity.main;

import java.util.List;

import org.hibernate.Session;

import com.cryptocurrency.entity.factories.HibernateCurrencyDailyPriceFactory;
import com.cryptocurrency.entity.objects.CurrencyDailyPrice;
import com.cryptocurrency.nomics.api.GetCurrency;

import kong.unirest.json.JSONArray;

public class CurrencyDailyPriceEntityList {

	public static void main(String[] args) {
		Session session = HibernateCurrencyDailyPriceFactory.getSessionFactory().openSession();
		session.beginTransaction();

		JSONArray json = GetCurrency.Currencies("", "7d");
		List<CurrencyDailyPrice> currencyInfoList = GetCurrency.CurrencyDailyPrice(json);

		for (CurrencyDailyPrice currencyInfo : currencyInfoList) {
			System.out.println(currencyInfo);
			session.save(currencyInfo);
		}

		session.getTransaction().commit();
		HibernateCurrencyDailyPriceFactory.shutdown();
	}
}