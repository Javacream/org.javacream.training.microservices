package org.javacream.training.books.service.impl;

import org.javacream.training.books.service.api.IsbnGenerator;
import org.springframework.stereotype.Service;

@Service
public class SimpleIsbnGenerator implements IsbnGenerator{

	@Override
	public String next() {
		return "ISBN" + Math.abs(Math.random());
	}

}
