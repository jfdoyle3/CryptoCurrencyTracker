package com.cryptocurrency.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cryptocurrency.backend.entity.objects.CryptocurrencyInfo;

public interface CryptocurrencyInfoRepository extends JpaRepository<CryptocurrencyInfo, Long> {
}
