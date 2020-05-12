package org.javacream.training.store.impl;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepository extends JpaRepository<StoreEntry, StoreId>{

}
