package com.cryptocurrency.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cryptocurrency.backend.entities.CryptocurrencyInterval;

public interface CryptocurrencyIntervalRepository extends JpaRepository<CryptocurrencyInterval, Long> {

}
