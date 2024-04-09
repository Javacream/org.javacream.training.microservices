package org.javacream.books.order.api;

import org.javacream.OrderConfiguration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(classes = OrderConfiguration.class)
@ActiveProfiles("test")

public class NewOrderTest {
    @Autowired private OrderService orderService;

    @Test public void order40Isbn100CreatesOkOrder(){
        Order order = orderService.order("Isbn100", 40);
        Assertions.assertEquals(Order.OrderStatus.OK, order.getStatus());
    }
    @Test public void order50Isbn100CreatesPendingOrder(){
        Order order = orderService.order("Isbn100", 50);
        Assertions.assertEquals(Order.OrderStatus.PENDING, order.getStatus());
    }
    @Test public void order50UnknownIsbnCreatesUnavailableOrder(){
        Order order = orderService.order("UnknownIsbn", 50);
        Assertions.assertEquals(Order.OrderStatus.UNAVAILABLE, order.getStatus());
    }

}