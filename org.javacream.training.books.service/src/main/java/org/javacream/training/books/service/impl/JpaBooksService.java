package org.javacream.training.books.service.impl;

import java.util.Collection;
import java.util.stream.Collectors;

import org.javacream.training.books.service.api.Book;
import org.javacream.training.books.service.api.BookException;
import org.javacream.training.books.service.api.BooksService;
import org.javacream.training.books.service.api.IsbnGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JpaBooksService implements BooksService{
	@Autowired private BooksRepository booksRepository;
	@Autowired private IsbnGenerator isbnGenerator;
	@Autowired private ReadingStoreService readingStoreService;
	private long delay = 0;
	@Override
	public String newBook(String title) throws BookException {
		String isbn = isbnGenerator.next();
		Book book = new Book();
		book.setIsbn(isbn);
		book.setTitle(title);
		booksRepository.save(book);
		return isbn;
	}

	@Override
	public Book findBookByIsbn(String isbn) throws BookException {
		delay++;
		if (delay > 4) {
			delay = 0;
		}
		Book book = booksRepository.findById(isbn).get();
		book.setAvailable(readingStoreService.getStockDelayed("books", isbn, delay) > 0);
		return book;
	}

	@Override
	public Book updateBook(Book book) throws BookException {
		booksRepository.save(book);
		return book;
	}

	@Override
	public void deleteBookByIsbn(String isbn) throws BookException {
		booksRepository.deleteById(isbn);
		
	}

	@Override
	public Collection<Book> findAllBooks() {
		return booksRepository.findAll().stream().map((book) -> {book.setAvailable(readingStoreService.getStock("books", book.getIsbn()) > 0); return book;}).collect(Collectors.toList());
	}
	
	
}
