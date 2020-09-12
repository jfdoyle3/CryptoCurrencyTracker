package com.cryptocurrency.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cryptocurrency.entity.objects.Cryptocurrency;

@Repository
public interface CurrencyRepository extends JpaRepository<Cryptocurrency, Integer> {

}
