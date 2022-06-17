package com.cryptocurrency.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cryptocurrency.backend.entity.objects.CryptocurrencyInfo;
import com.cryptocurrency.backend.payload.response.Cryptocurrency;
import com.cryptocurrency.backend.services.CurrencyToEntity;

public interface CryptocurrencyInfoRepository extends JpaRepository<CryptocurrencyInfo, Long> {

	

}
