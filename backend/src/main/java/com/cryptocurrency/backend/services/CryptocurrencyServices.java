package com.cryptocurrency.backend.services;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Service;

import com.cryptocurrency.entity.factories.HibernateCryptocurrencyFactory;
import com.cryptocurrency.entity.objects.CryptocurrencyEntity;

@Service
public class CryptocurrencyServices {

	// private String defaultSearch="BTC,ETH,USDT,XRP,BCH,BSV,LTC,BNB,EOS,ADA";
	private String defaultSearch = "";
//	private List<CryptocurrencyEntity> currencyList = ListCurrencies.CreateCurrencyList(defaultSearch);
	
	// Show All currencies in List
	public List<CryptocurrencyEntity> findAll() {
		List<CryptocurrencyEntity> makeList=new ArrayList<>();
		Session session = HibernateCryptocurrencyFactory .getSessionFactory().openSession();
		session.beginTransaction();

		String hql = "from CryptocurrencyEntity";
		Query<CryptocurrencyEntity> query = session.createQuery(hql);
		List<CryptocurrencyEntity> listCurrencies = query.list();
		  
		for(CryptocurrencyEntity currency : listCurrencies) {
		//	System.out.println(currency);
			makeList.add(currency);
			
		}
		
		session.getTransaction().commit();
		HibernateCryptocurrencyFactory .shutdown();
		System.out.println("----->   "+makeList.get(0));
		return makeList;
	}
//	public List<CryptocurrencyEntity> listTopFive() {
//		List<CryptocurrencyEntity> topFiveList = new ArrayList<>();
//		for (int idx = 0; idx < 5; idx++) {
//			topFiveList.add(currencyList.get(idx));
//		}
//
//		return topFiveList;
//
//}
	
	public List<CryptocurrencyEntity> listTopFive() {
		List<CryptocurrencyEntity> topFiveList = new ArrayList<>();
		Session session = HibernateCryptocurrencyFactory.getSessionFactory().openSession();
		session.beginTransaction();

		String hql = "from Cryptocurrencies";
		Query<CryptocurrencyEntity> query = session.createQuery(hql);
		List<CryptocurrencyEntity> listCurrencies = query.list();
		 
		for (int idx=0; idx<5; idx++) {
			System.out.println(listCurrencies.get(idx));
			topFiveList.add(listCurrencies.get(idx));
		}
		
		session.getTransaction().commit();
		HibernateCryptocurrencyFactory.shutdown();
	

		return topFiveList;

	}

	// Find A Currency in the List
//	public CryptocurrencyHeader findById(long id) {
//		for (CryptocurrencyHeader currency : currencyList) {
//			if (currency.getId() == id) {
//			//	System.out.println(currency);
//				return currency;
//			}
//
//		}
//		return null;
//	}

	// Get Currency Symbol in the API
//	public CryptocurrencyHeader findByCurrencyBySymbol(String currencySearch) {
//		String currencySymbol = currencySearch.toUpperCase();
//		for (CryptocurrencyHeader currency : currencyList) {
//			if (currency.getSymbol().equals(currencySymbol)) {
//				return currency;
//			}
//		}
//		return null;
//	}

	// Delete by Id
//	public Cryptocurrency deleteById(long id) {
//		Cryptocurrency currency = findById(id);
//		if (currency==null) return null;
//		if(currencyList.remove(currency)) {
//		return currency;
//		}
//		return null;
//	}

	// Save / Update
//	public Cryptocurrency save(Cryptocurrency cryptoCurrency) {
//		if (cryptoCurrency.getId()==-1 || cryptoCurrency.getId()==0) {
//			cryptoCurrency.setId(++idCounter);
//			currencyList.add(cryptoCurrency);
//		}else {
//			deleteById(cryptoCurrency.getCurrencyId());
//			currencyList.add(cryptoCurrency);
//		}
//		return cryptoCurrency;
//	}

}
