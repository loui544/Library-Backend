package com.library.security.book.repository;

import com.library.security.book.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository  extends JpaRepository<Book,Long> {
    public Book findByName(String name);
    public List<Book> findByNameContainingIgnoreCase(String name);

    public List<Book> findBookByAuthorContaining(String author);
}
