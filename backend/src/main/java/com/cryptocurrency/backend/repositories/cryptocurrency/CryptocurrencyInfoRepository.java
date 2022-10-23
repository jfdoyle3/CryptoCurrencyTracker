package com.cryptocurrency.backend.repositories.cryptocurrency;



import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cryptocurrency.backend.entities.cryptocurrencies.CryptocurrencyInfo;


public interface CryptocurrencyInfoRepository extends JpaRepository<CryptocurrencyInfo, Long> {
	
	@Query("SELECT C FROM CryptocurrencyInfo C WHERE C.ranking<6 ORDER BY C.ranking+0 ASC")
	List<CryptocurrencyInfo> findTopFive();
	
	@Query("SELECT COUNT(*) FROM CryptocurrencyInfo")
	Long numberOfEntries();
	
	List<CryptocurrencyInfo> findAll();
	
	Set<CryptocurrencyInfo> findBySymbol(String currency);
	
	List<CryptocurrencyInfo> findAllByRatings_tracker_id(Long id);
	
	void deleteBySymbol(String currency);
	
	
}
