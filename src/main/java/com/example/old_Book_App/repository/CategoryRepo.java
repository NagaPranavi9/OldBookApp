package com.example.old_Book_App.repository;

import com.example.old_Book_App.Model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category, Long> {}
