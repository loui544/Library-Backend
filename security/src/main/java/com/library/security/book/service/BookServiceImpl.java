package com.library.security.book.service;

import com.library.security.book.entity.Book;
import com.library.security.book.error.BookNotFoundException;
import com.library.security.book.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService{

    @Autowired
    private BookRepository bookRepository;
    @Override
    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public List<Book> findBookList() {
        return bookRepository.findAll();
    }

    @Override
    public Book findBookById(Long bookId) throws BookNotFoundException {
        Optional<Book> book=  bookRepository.findById(bookId);
        if (!book.isPresent()){
            throw  new BookNotFoundException("Book not available");
        }
        return book.get();
    }

    @Override
    public void deleteBookById(Long bookId) {
        bookRepository.deleteById(bookId);
    }

    @Override
    public Book updateBook(Long bookId, Book book) {
        Book bookDB= bookRepository.findById(bookId).get();
        if(Objects.nonNull(book.getImage()) && !"".equalsIgnoreCase(book.getImage())){
            bookDB.setImage(book.getImage());
        }
        if(Objects.nonNull(book.getName()) && !"".equalsIgnoreCase(book.getName())){
            bookDB.setName(book.getName());
        }
        if(Objects.nonNull(book.getResume()) && !"".equalsIgnoreCase(book.getResume())){
            bookDB.setResume(book.getResume());
        }
        if(Objects.nonNull(book.getAuthor()) && !"".equalsIgnoreCase(book.getAuthor())){
            bookDB.setAuthor(book.getAuthor());
        }
        if(Objects.nonNull(book.getPublisher()) && !"".equalsIgnoreCase(book.getPublisher())){
            bookDB.setPublisher(book.getPublisher());
        }
        if(Objects.nonNull(book.getDate()) && !"".equalsIgnoreCase(String.valueOf(book.getDate()))){
            bookDB.setDate(book.getDate());
        }
        if(Objects.nonNull(book.getName()) && !"".equalsIgnoreCase(book.getName())){
            bookDB.setName(book.getName());
        }
        return bookRepository.save(bookDB);
    }

    @Override
    public List<Book> findBookByName(String name) {
        return bookRepository.findByNameContainingIgnoreCase(name);
    }

    @Override
    public List<Book> findBookByAuthor(String author) {
        return bookRepository.findBookByAuthorContaining(author);
    }


}
