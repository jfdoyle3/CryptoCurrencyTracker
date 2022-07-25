package com.cryptocurrency.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cryptocurrency.backend.entities.cryptocurrencies.CryptocurrencyInterval;

public interface CryptocurrencyIntervalRepository extends JpaRepository<CryptocurrencyInterval, Long> {

}
