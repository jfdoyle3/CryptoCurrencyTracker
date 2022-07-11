package com.cryptocurrency.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cryptocurrency.backend.entity.objects.CryptocurrencyDailyPrice;

public interface CryptocurrencyDailyPriceRepository extends JpaRepository<CryptocurrencyDailyPrice, Long>{
	
	
	CryptocurrencyDailyPrice findBySymbol(String symbol);
	
	@Query("SELECT COUNT(*) FROM CryptocurrencyDailyPrice")
	Long numberOfEntries();
}
