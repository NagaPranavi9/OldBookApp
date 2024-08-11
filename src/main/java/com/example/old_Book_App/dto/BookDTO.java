package com.example.old_Book_App.dto;

import lombok.Data;

@Data
public class BookDTO {

    private Long id;
    private String title;
    private Long categoryId;
    private Long standardId;
    private String condition;
    private String purpose;
    private Double actualPrice;
    private Double sellingPrice;
}
