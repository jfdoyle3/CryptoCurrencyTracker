package com.cryptocurrency.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cryptocurrency.backend.entities.CryptocurrencyDailyPrice;

public interface CryptocurrencyDailyPriceRepository extends JpaRepository<CryptocurrencyDailyPrice, Long>{
	
	
	List<CryptocurrencyDailyPrice> findBySymbol(String symbol);
	
	@Query("SELECT COUNT(*) FROM CryptocurrencyDailyPrice")
	Long numberOfEntries();
}
