package com.example.old_Book_App.controller;

import com.example.old_Book_App.Model.Book;
import com.example.old_Book_App.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/category/{category}")
    public List<Book> getBooksByCategory(@PathVariable String category) {
        return bookService.getBooksByCategory(category);
    }

    @GetMapping("/educational/{standard}")
    public List<Book> getEducationalBooksByStandard(@PathVariable String standard) {
        return bookService.getEducationalBooksByStandard(standard);
    }

    @GetMapping("/exchange")
    public List<Book> getBooksForExchange() {
        return bookService.getBooksForExchange();
    }

    @PostMapping
    public Book addBook(@RequestBody Book book) {
        return bookService.addBook(book);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
    }
}
