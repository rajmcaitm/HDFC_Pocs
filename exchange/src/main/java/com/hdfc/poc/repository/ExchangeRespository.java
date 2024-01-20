package com.hdfc.poc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hdfc.poc.config.CurrencyRate;

@Repository
public interface ExchangeRespository  extends JpaRepository<CurrencyRate, Long>{

}
