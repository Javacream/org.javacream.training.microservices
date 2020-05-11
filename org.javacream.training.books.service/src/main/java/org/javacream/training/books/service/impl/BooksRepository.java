package org.javacream.training.books.service.impl;

import org.javacream.training.books.service.api.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BooksRepository extends JpaRepository<Book, String>{

}
