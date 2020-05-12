package org.javacream.order.books;

import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class BooksService {

	@Autowired
	@Qualifier("booksService")
	private RestTemplate restTemplate;

	@Autowired
	private CircuitBreakerFactory circuitBreakerFactory;

	public OrderBook findBookByIsbn(String isbn) {
		Supplier<OrderBook> supplier = () -> restTemplate.getForObject("http://localhost:9090/books/" + isbn, OrderBook.class);
		return circuitBreakerFactory.create("booksServiceCircuitBreaker").run(supplier);
	}

}