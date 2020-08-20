package com.cryptocurrency.backend.services;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.stereotype.Service;

import com.cryptocurrency.entity.crud.GetACurrency;
import com.cryptocurrency.entity.crud.GetAllCurrencies;
import com.cryptocurrency.entity.crud.GetTopFiveCryptocurrencies;
import com.cryptocurrency.entity.objects.Cryptocurrency;

@Service
public class CryptocurrencyServices {

	// private String defaultSearch="BTC,ETH,USDT,XRP,BCH,BSV,LTC,BNB,EOS,ADA";
	private String defaultSearch = "";
//	private List<Cryptocurrency> currencyList = ListCurrencies.CreateCurrencyList(defaultSearch);
	
	// Show All currencies in List
	public List<Cryptocurrency> findAll() {
		System.out.println("---> All Service running <---");
		List<Cryptocurrency> all=GetAllCurrencies.getCurrencies();
		return all;
	}
//	public List<Cryptocurrency> listTopFive() {
//		List<Cryptocurrency> topFiveList = new ArrayList<>();
//		for (int idx = 0; idx < 5; idx++) {
//			topFiveList.add(currencyList.get(idx));
//		}
//
//		return topFiveList;
//
//}
	
//	public List<Cryptocurrency> listTopFive() {
//		System.out.println("---> TopFive Service running <---");
//		List<Cryptocurrency> topFive=GetTopFiveCryptocurrencies.getTopFive();
//		return topFive;
//
//	}
	public List<Cryptocurrency> listTopFive() {
		List<Cryptocurrency> currenciesList=new ArrayList<>();
		SessionFactory factory = new Configuration().configure()
				.addAnnotatedClass(Cryptocurrency.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {
			session.beginTransaction();
			  Query<Cryptocurrency> query = session.createQuery("from Cryptocurrency", Cryptocurrency.class);

		 
		        query.setFirstResult(0);
		        query.setMaxResults(5);

		        List<Cryptocurrency> queryList = query.list();
				for(Cryptocurrency currency : queryList) {
			System.out.println("sf:->   "+currency);
			currenciesList.add(currency);
		}
			
			session.getTransaction().commit();
			System.out.println("Done!");

		} catch (Exception err) {
			err.printStackTrace();

		} finally {
			session.close();
			factory.close();
		}
		for(Cryptocurrency currency : currenciesList) {
		System.out.println("currencies list----->   "+currency);
		}
		return currenciesList;

	}
	
	// Get Currency Symbol static object
//		public  Cryptocurrency findByCurrencyBySymbol(String currencySearch) {
//			String currencySymbol = currencySearch.toUpperCase();
//		//	List<Cryptocurrency> symbolList=new ArrayList<Cryptocurrency>();
//			System.out.printf("\n---> Symbol: %s Service running <---",currencySymbol);
//			//List<Cryptocurrency> symbol=GetACurrency.getACurrency();
//			
//			Cryptocurrency currency = new Cryptocurrency("ZXY", "BTC", "BTC", "Bitcoin","1",
//					"https://s3.us-east-2.amazonaws.com/nomics-api/static/images/currencies/btc.svg");
////			symbolList.add(currency);
//			
//			return currency;
//			
//		}
	// Get Currency Symbol in the API
		public Cryptocurrency findByCurrencyBySymbol(String currencySearch) {
			String currencySymbol = currencySearch.toUpperCase();
			return GetACurrency.getACurrency();
		//	return null;
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
//	public Cryptocurrency findByCurrencyBySymbol(String currencySearch) {
//		String currencySymbol = currencySearch.toUpperCase();
//		for (Cryptocurrency currency : currencyList) {
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
