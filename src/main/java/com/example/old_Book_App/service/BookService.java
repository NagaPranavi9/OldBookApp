package com.example.old_Book_App.service;

import com.example.old_Book_App.Model.Book;
import com.example.old_Book_App.repository.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BookService {


    @Autowired
    private BookRepo bookRepo;

    public List<Book> getAllBooks() {
        return bookRepo.findAll();
    }

    public List<Book> getBooksByCategory(String category) {
        return bookRepo.findByCategory(category);
    }

    public List<Book> getEducationalBooksByStandard(String standard) {
        return bookRepo.findByCategoryAndStandard("Educational", standard);
    }

    public List<Book> getBooksForExchange() {
        return bookRepo.findByForExchange(true);
    }

    public Book addBook(Book book) {
        return bookRepo.save(book);
    }

    public void deleteBook(Long id) {
        bookRepo.deleteById(id);
    }


}
