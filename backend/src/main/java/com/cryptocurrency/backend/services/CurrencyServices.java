package com.cryptocurrency.backend.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cryptocurrency.entity.objects.Cryptocurrency;
import com.cryptocurrency.jpa.repository.CurrencyRepository;

@Service
public class CurrencyServices {
	
	@Autowired
	private CurrencyRepository repository;
	
	public Cryptocurrency saveCryptocurrency(Cryptocurrency Cryptocurrency) {
		return repository.save(Cryptocurrency);
	}
	public List<Cryptocurrency> saveCryptocurrencyList(List<Cryptocurrency> Cryptocurrencys) {
		return repository.saveAll(Cryptocurrencys);
	}
	public List<Cryptocurrency> getCryptocurrencyList(){
		return repository.findAll();
	}
	public Cryptocurrency getCryptocurrencyById(Integer id){
		return repository.findById(id).orElse(null);
	}
//	public Cryptocurrency getCryptocurrencyFirstName(String firstName){
//		return repository.findByFirstName(firstName);
//	}
	
	public String deleteCryptocurrency(Integer id) {
		 repository.deleteById(id);
		return "Cryptocurrency "+id+" deleted !!";
	}
//	public Cryptocurrency updateCryptocurrencyName(Cryptocurrency Cryptocurrency) {
//		Cryptocurrency existingCryptocurrency=repository.findById(Cryptocurrency.getId()).orElse(null);
//		existingCryptocurrency.setFirstName(Cryptocurrency.getFirstName());
//		existingCryptocurrency.setLastName(Cryptocurrency.getLastName());
//		return repository.save(existingCryptocurrency);
//	}
	
	

}

