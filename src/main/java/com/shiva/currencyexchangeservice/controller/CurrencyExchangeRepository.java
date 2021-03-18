package com.shiva.currencyexchangeservice.controller;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchange,Long> {
    CurrencyExchange findByFromAndTo(String from,String to);

}
