package org.javacream.store.test;

import org.javacream.store.api.StoreService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class StoreServiceTests {

	@Autowired StoreService storeService;
	@Test public void contextLoads() {
		
	}
	@Test public void stockForIsbn100Is42() {
		Assertions.assertEquals(42, storeService.getStock("books", "Isbn100"));
		
	}
}
