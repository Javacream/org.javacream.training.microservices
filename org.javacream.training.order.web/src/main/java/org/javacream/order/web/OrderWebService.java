package org.javacream.order.web;

import org.javacream.order.api.Order;
import org.javacream.order.api.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/order")
public class OrderWebService {
	@Autowired OrderService orderService;

	@PostMapping(path = "{isbn}/{number}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Order order(@PathVariable("isbn") String isbn, @PathVariable("number") int number) {
		return orderService.order(isbn, number);
	}

	@GetMapping(path = "{orderId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Order findById(@PathVariable("orderId") Long id) {
		return orderService.findById(id);
	}
	
	
}
