package org.javacream.order.impl;

import org.javacream.order.api.Order;
import org.javacream.order.api.OrderService;
import org.javacream.order.books.BooksService;
import org.javacream.order.books.OrderBook;
import org.javacream.order.store.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JpaOrderService implements OrderService {

	@Autowired private OrderRepository orderRepository;
	@Autowired
	private BooksService booksService;
	@Autowired
	private StoreService storeService;

	@Override
	public Order order(String isbn, int number) {
		String orderStatus;
		double totalPrice = 0;
		if (isbn == null) {
			throw new IllegalArgumentException("isbn was null");
		}
		if (number <= 0) {
			throw new IllegalArgumentException("number must be poitive, was " + number);
		}
		int stock = 0;
		try {
			OrderBook book = booksService.findBookByIsbn(isbn);
			totalPrice = book.getPrice() * number;
			stock = storeService.getStock("BOOKS", isbn);
			if (stock < number) {
				orderStatus = "PENDING";
			} else {
				orderStatus = "OK";
			}
		}

		catch (Exception e) {
			orderStatus = "UNAVAILABLE";
		}
		
		Order order =  new Order(isbn, totalPrice, orderStatus);
		orderRepository.save(order);
		return order;
	}
	@Override
	public Order findById(Long id) {
		return orderRepository.findById(id).get();
	}

}
