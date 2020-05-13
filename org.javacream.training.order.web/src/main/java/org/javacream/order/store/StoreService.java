package org.javacream.order.store;

import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class StoreService {
	@Value("${storeEndpoint}") private String storeEndpoint;

	@Autowired
	@Qualifier("store")

	private RestTemplate restTemplate;

	@Autowired
	private CircuitBreakerFactory circuitBreakerFactory;

	public Integer getStock(String category, String id) {
		Supplier<Integer> supplier = () -> Integer.parseInt(
				restTemplate.getForObject(storeEndpoint + category + "/" + id, String.class));
		return circuitBreakerFactory.create("storeCircuitBreaker").run(supplier);
	}

}