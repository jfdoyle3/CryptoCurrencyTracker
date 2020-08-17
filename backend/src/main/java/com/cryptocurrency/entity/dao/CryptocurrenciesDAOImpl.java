package com.cryptocurrency.entity.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cryptocurrency.entity.objects.Cryptocurrency;

@Repository
public class CryptocurrenciesDAOImpl implements CryptocurrencyDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional
	public List<Cryptocurrency> getCurrency() {
		
		Session currentSession=sessionFactory.getCurrentSession();	
		
		Query<Cryptocurrency> theQuery=currentSession.createQuery("from Cryptocurrency", Cryptocurrency.class);
		
		List<Cryptocurrency> currencies=theQuery.getResultList();
		
		return currencies;
	}

}
