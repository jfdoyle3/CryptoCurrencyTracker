package com.cryptocurrency.backend.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cryptocurrency.backend.entity.objects.CryptocurrencyInfo;

public interface CryptocurrencyInfoRepository extends JpaRepository<CryptocurrencyInfo, Long> {
	
	@Query("SELECT C FROM CryptocurrencyInfo C WHERE C.ranking<11 ORDER BY C.ranking DESC")
	List<CryptocurrencyInfo> findTopTen();
	
	@Query("SELECT COUNT(*) FROM CryptocurrencyInfo")
	Long numberOfEntries();
	
	List<CryptocurrencyInfo> findAll();
}
