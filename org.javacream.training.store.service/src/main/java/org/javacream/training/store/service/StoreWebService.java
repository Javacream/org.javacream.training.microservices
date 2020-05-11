package org.javacream.training.store.service;

import org.javacream.training.store.api.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springfox.documentation.swagger2.annotations.EnableSwagger2;
@EnableSwagger2
@RestController
@RequestMapping(path = "api")
public class StoreWebService {
	@Autowired private StoreService storeService;


	@GetMapping(path = "store/{category}/{item}", produces = MediaType.TEXT_PLAIN_VALUE)
	public String getStock(@PathVariable("category") String category, @PathVariable("item") String item) {
		return Integer.toString(storeService.getStock(category, item));
	}	
	
}
