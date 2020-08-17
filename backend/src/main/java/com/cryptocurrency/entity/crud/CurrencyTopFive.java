package com.cryptocurrency.entity.crud;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.cryptocurrency.entity.factories.HibernateCryptocurrencyFactory;
import com.cryptocurrency.entity.objects.Cryptocurrency;

public class CurrencyTopFive {

	public static List<Cryptocurrency> TopFiveList() {

		List<Cryptocurrency> topFiveList = new ArrayList<>();
		List<Cryptocurrency> all = GetAllCurrencies.getCurrencies();
		for (int idx = 0; idx < 5; idx++) {
			System.out.println("----->  " + all.get(idx));
			topFiveList.add(all.get(idx));
		}

		return topFiveList;

	}
}