package org.javacream.training.store.impl;

import org.javacream.training.store.api.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JpaStoreService implements StoreService {

	@Autowired private StoreRepository storeRepository;
	@Override
	public int getStock(String category, String itemId) {
		StoreId storeId = new StoreId(category, itemId);
		
		StoreEntry storeEntry = storeRepository.findById(storeId).orElse(new StoreEntry(category, itemId, 0));
		return storeEntry.getStock();
	}

}
