package org.javacream.training.store.service;

import org.javacream.training.store.api.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springfox.documentation.swagger2.annotations.EnableSwagger2;
@EnableSwagger2
@RestController
@RequestMapping(path = "api")
@ManagedResource(objectName = "javacream:type=service,name=store")
public class StoreWebService {
	
	@Autowired private StoreService storeService;


	@GetMapping(path = "store/{category}/{item}", produces = MediaType.TEXT_PLAIN_VALUE)
	public String getStock(@PathVariable("category") String category, @PathVariable("item") String item) {
		invocationCounter++;
		return Integer.toString(storeService.getStock(category, item));
	}	
	
	private int invocationCounter;


	@ManagedAttribute(description = "invocations")
	public int getInvocationCounter() {
		return invocationCounter;
	}
	
	@ManagedOperation(description = "reset invocations")
	public void resetCounter() {
		invocationCounter = 0;
	}
	
}
