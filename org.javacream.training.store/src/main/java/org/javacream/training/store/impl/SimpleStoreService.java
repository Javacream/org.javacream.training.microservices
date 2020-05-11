package org.javacream.training.store.impl;

import org.javacream.training.store.api.StoreService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class SimpleStoreService implements StoreService {

	@Value("${stock}") private int defaultStock;
	@Override
	public int getStock(String category, String itemId) {
		return defaultStock;
	}

}
