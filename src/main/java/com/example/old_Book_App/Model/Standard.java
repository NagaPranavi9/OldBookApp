package com.example.old_Book_App.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Standard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}
