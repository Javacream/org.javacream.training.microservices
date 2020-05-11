package org.javacream.training.books.service.impl;

import java.util.Collection;

import org.javacream.training.books.service.api.Book;
import org.javacream.training.books.service.api.BookException;
import org.javacream.training.books.service.api.BooksService;
import org.javacream.training.books.service.api.IsbnGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JpaBoksService implements BooksService{
	@Autowired private BooksRepository booksRepository;
	@Autowired private IsbnGenerator isbnGenerator;
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
		return booksRepository.findById(isbn).get();
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
		return booksRepository.findAll();
	}
	
	
}
