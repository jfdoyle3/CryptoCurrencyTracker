package com.cryptocurrency.backend.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cryptocurrency.backend.entities.CryptocurrencyInfo;

public interface CryptocurrencyInfoRepository extends JpaRepository<CryptocurrencyInfo, Long> {
	
	@Query("SELECT C FROM CryptocurrencyInfo C WHERE C.ranking<6 ORDER BY C.ranking+0 ASC")
	List<CryptocurrencyInfo> findTopFive();
	
	@Query("SELECT COUNT(*) FROM CryptocurrencyInfo")
	Long numberOfEntries();
	
	List<CryptocurrencyInfo> findAll();
}
