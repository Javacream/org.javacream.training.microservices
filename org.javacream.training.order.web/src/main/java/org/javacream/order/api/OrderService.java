package org.javacream.order.api;


public interface OrderService {
	Order order (String isbn, int number);
	Order findById(Long id);
}
