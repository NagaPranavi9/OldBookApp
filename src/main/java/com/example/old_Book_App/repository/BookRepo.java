package com.example.old_Book_App.repository;


import com.example.old_Book_App.Model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepo extends JpaRepository<Book, Long> {
    List<Book> findByCategory(String category);

    List<Book> findByCategoryAndStandard(String category, String standard);

    List<Book> findByForExchange(boolean forExchange);
}

