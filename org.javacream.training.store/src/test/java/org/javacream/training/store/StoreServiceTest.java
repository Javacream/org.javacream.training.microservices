package org.javacream.training.store;

import org.javacream.training.store.api.StoreService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("test")
public class StoreServiceTest {
	@Autowired private StoreService storeService;
	@Test public void simpleStoreService() {
		int stock = storeService.getStock("this", "that");
		Assert.assertTrue(42 == stock);
	}
}
