package com.hdfc.poc.service;

import java.util.Arrays;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hdfc.poc.bean.CurrencyAPIResponse;

@Service
public class ExchangeService {

	@Autowired
	private RestTemplate restTemplate;

	@Value("${app.currencyapi.apikey}")
	private String apiKey;

	@Value("${app.currencyapi.baseurl}")
	private String baseurl;

	public CurrencyAPIResponse getExchangeRate(String baseCurrency, String currencies) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.set("apikey", apiKey);
		HttpEntity<String> entity = new HttpEntity<String>(headers);

		String url = baseurl + "/latest";

		if(null != baseCurrency) {
			url += "?base_currency=" + baseCurrency;
		}
		if(null != currencies) {
			url += "&currencies=" + currencies;
		}
		String res = restTemplate.exchange(url, HttpMethod.GET, entity, String.class).getBody();
		JSONObject jsonObject = new JSONObject(res);
		System.out.println(jsonObject);

		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.readValue(res, CurrencyAPIResponse.class);

		} catch (JsonMappingException e) { // TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) { // TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;

	}

	public CurrencyAPIResponse getConvertedRate(String amount, String baseCurrency, String currencies) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.set("apikey", apiKey);
		HttpEntity<String> entity = new HttpEntity<String>(headers);

		String url = baseurl + "/convert";
		
		if(null != amount) {
			url += "?&value="+amount;
		} 
		if(null != baseCurrency) {
			url += "&base_currency=" + baseCurrency;
		}
		if(null != currencies) {
			url += "&currencies=" + currencies;
		}

		String res = restTemplate.exchange(url, HttpMethod.GET, entity, String.class).getBody();
		JSONObject jsonObject = new JSONObject(res);
		System.out.println(jsonObject);

		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.readValue(res, CurrencyAPIResponse.class);

		} catch (JsonMappingException e) { // TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) { // TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;

	}
}
