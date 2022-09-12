package com.cryptocurrency.backend.repositories.cryptocurrency;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cryptocurrency.backend.entities.cryptocurrencies.CryptocurrencyDailyPrice;

public interface CryptocurrencyDailyPriceRepository extends JpaRepository<CryptocurrencyDailyPrice, Long>{
	
	
	List<CryptocurrencyDailyPrice> findBySymbol(String symbol);
	
	@Query("SELECT COUNT(*) FROM CryptocurrencyDailyPrice")
	Long numberOfEntries();
	
	// Gets the Last Record on the table
	CryptocurrencyDailyPrice findTopByOrderByIdDesc();


	
	
	
}
