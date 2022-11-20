package com.library.security.book.controller;

import com.library.security.book.entity.Book;
import com.library.security.book.error.BookNotFoundException;
import com.library.security.book.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/library/books")
@CrossOrigin("*")
public class BookController {

    @Autowired
    private BookService bookService;

    private final Logger logger= LoggerFactory.getLogger(BookController.class);

    @PostMapping("/create")
    public Book saveBook(@Valid @RequestBody Book book){
        return bookService.saveBook(book);
    }
    //search
    @GetMapping("/read")
    public List<Book> findBookList(){
        return bookService.findBookList();
    }

    @GetMapping("/read/{id}")
    public Book findBookById(@PathVariable("id") Long bookId) throws BookNotFoundException {
        return bookService.findBookById(bookId);
    }

    @GetMapping("/read/name/{name}")
    public List<Book> findBookByName(@PathVariable("name") String name){
        return bookService.findBookByName(name);
    }

    @GetMapping("/read/author/{author}")
    public List<Book> findBookByAuthor(@PathVariable("author") String author){
        return  bookService.findBookByAuthor(author);
    }
    //Delete
    @DeleteMapping("/delete/{id}")
    public String deleteBookById(@PathVariable("id") Long bookId){
        bookService.deleteBookById(bookId);
        return "Book deleted successfully!!";
    }
    //Update
    @PutMapping("/update/{id}")
    public Book updateBook(@PathVariable("id") Long bookId, @RequestBody Book book){
        return bookService.updateBook(bookId,book);
    }
}
