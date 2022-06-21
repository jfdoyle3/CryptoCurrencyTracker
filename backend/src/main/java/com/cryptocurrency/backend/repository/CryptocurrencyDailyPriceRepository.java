package com.cryptocurrency.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cryptocurrency.backend.entity.objects.CryptocurrencyDailyPrice;

public interface CryptocurrencyDailyPriceRepository extends JpaRepository<CryptocurrencyDailyPrice, Long>{

}
