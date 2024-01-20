package com.hdfc.poc.controller;

import java.sql.Connection;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import javax.websocket.server.PathParam;

import org.json.HTTP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hdfc.poc.bean.CurrencyAPIResponse;
import com.hdfc.poc.bean.ExchangeRate;
import com.hdfc.poc.config.CurrencyRate;
import com.hdfc.poc.filter.PostgreConnection;
import com.hdfc.poc.repository.ExchangeRespository;
import com.hdfc.poc.service.ExchangeService;

@RestController
public class ExchangeController {

	@Autowired
	ExchangeService exchangeService; 
	
	@Autowired
	ExchangeRespository exchangeRespository;
	

	@GetMapping(value = "/exchangeRate")
	public ResponseEntity<?> getExchangeRate(
			@RequestParam(name = "baseCurrency", required = false) String baseCurrency,
			@RequestParam(name = "currencies", required = false) String currencies) {

		Map<String, ExchangeRate> datagot= exchangeService.getExchangeRate(baseCurrency, currencies).getData();
          Connection con = null;
           Statement stmt = null;
              try {
             con = PostgreConnection.getConnection();
             stmt = con.createStatement();         
		for (Map.Entry<String,ExchangeRate> entry : datagot.entrySet()) {
			String query="insert into currency_rate(currency,rate) values('"+entry.getKey()+"',"+entry.getValue().getValue()+")";
			stmt.execute(query);
            System.out.println("currency = " + entry.getKey() +
                             ", rate = " + entry.getValue().getValue());
		}
              }catch (Exception e) {

			}
		return new ResponseEntity<>(HttpStatus.OK);
	}

	
	@GetMapping(value = "/exchangeRateValue")
	public Double getExchangeRate123(
			@RequestParam(name = "baseCurrency", required = false) String baseCurrency,
			@RequestParam(name = "currencies", required = false) String currencies) {

		Map<String, ExchangeRate> datagot= exchangeService.getExchangeRate(baseCurrency, currencies).getData();
		double data = 0;
              try {        
		for (Map.Entry<String,ExchangeRate> entry : datagot.entrySet()) {
			data= entry.getValue().getValue();
		}
              }catch (Exception e) {
			}
		return  data;
	}

	 

}
