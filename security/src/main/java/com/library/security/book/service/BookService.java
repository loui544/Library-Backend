package com.library.security.book.service;

import com.library.security.book.entity.Book;
import com.library.security.book.error.BookNotFoundException;

import java.util.List;

public interface BookService {
    public Book saveBook(Book book);

    public List<Book> findBookList();

    public Book findBookById(Long bookId) throws BookNotFoundException;

    public void deleteBookById(Long bookId);

    public Book updateBook(Long bookId, Book book);

    List<Book> findBookByName(String name);

    List<Book> findBookByAuthor(String author);

}
