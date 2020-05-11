package org.javacream.training.books.service.api;


import java.util.Collection;


public interface BooksService{
	String newBook(String title) throws BookException;

	Book findBookByIsbn(String isbn) throws BookException;
	
	Book updateBook(Book book) throws BookException;
	
	void deleteBookByIsbn(String isbn) throws BookException;
	
	Collection<Book> findAllBooks();
}
