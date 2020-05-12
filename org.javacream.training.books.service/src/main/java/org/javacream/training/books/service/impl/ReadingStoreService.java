package org.javacream.training.books.service.impl;

import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ReadingStoreService {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private CircuitBreakerFactory circuitBreakerFactory;

	public Integer getStock(String category, String id) {
		Supplier<Integer> supplier = () -> Integer.parseInt(restTemplate.getForObject("http://localhost:8080/api/store/" + category + "/" + id, String.class)); 
		return circuitBreakerFactory.create("storeCircuitBreaker").run(supplier);
	}
	public Integer getStockDelayed(String category, String id, long delay) {
		Supplier<Integer> supplier = () -> Integer.parseInt(restTemplate.getForObject("http://localhost:8080/api/store/" + category + "/" + id + "?delay=" + delay, String.class)); 
		return circuitBreakerFactory.create("storeCircuitBreaker").run(supplier);
	}

}
