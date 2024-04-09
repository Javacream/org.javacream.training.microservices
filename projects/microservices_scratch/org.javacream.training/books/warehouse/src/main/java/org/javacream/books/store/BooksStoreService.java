package org.javacream.books.store;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="store")
public interface BooksStoreService {
	@GetMapping("api/{cat}/{item}")
	String getStockForBook(@PathVariable("cat") String cat, @PathVariable("item") String item);

}

/*Impl-Scratch
 * lookup auf die Service Discovery = Eureka unter dem Namen "store" -> REST-Zugriff auf Eureka
 * Rückgabe ist eine Liste von Host:Port -> Interner Client-Loadbalancer
 * Aufruf unter Verwendung einer http-Bibliothek auf den Endpoint Host:Port/{GetMapping}
 * Rückgabe oder Fehler 
 * 	Retry oder Exception
 */
