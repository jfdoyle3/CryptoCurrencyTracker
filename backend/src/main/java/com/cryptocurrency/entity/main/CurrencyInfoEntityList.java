package com.cryptocurrency.entity.main;

import java.util.List;

import org.hibernate.Session;

import com.cryptocurrency.entity.factories.HibernateCurrencyFactory;
import com.cryptocurrency.entity.factories.HibernateCurrencyInfoFactory;
import com.cryptocurrency.entity.objects.CurrencyDailyPriceEntity;
import com.cryptocurrency.nomics.api.GetCurrency;

import kong.unirest.json.JSONArray;

public class CurrencyInfoEntityList {

	public static void main(String[] args) {
		Session session = HibernateCurrencyInfoFactory.getSessionFactory().openSession();
		session.beginTransaction();

		JSONArray json = GetCurrency.Currencies("", "7d");
		List<CurrencyDailyPriceEntity> currencyInfoList = GetCurrency.CurrencyDailyPrice(json);

		for (CurrencyDailyPriceEntity currencyInfo : currencyInfoList) {
			System.out.println(currencyInfo);
			session.save(currencyInfo);
		}

		session.getTransaction().commit();
		HibernateCurrencyFactory.shutdown();
	}
}