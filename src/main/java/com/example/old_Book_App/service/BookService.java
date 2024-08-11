package com.example.old_Book_App.service;

import com.example.old_Book_App.Model.Book;
import com.example.old_Book_App.Model.Category;
import com.example.old_Book_App.Model.Standard;
import com.example.old_Book_App.dto.BookDTO;
import com.example.old_Book_App.repository.BookRepo;
import com.example.old_Book_App.repository.CategoryRepo;
import com.example.old_Book_App.repository.StandardRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {


    @Autowired
    private BookRepo bookRepository;

    @Autowired
    private CategoryRepo categoryRepository;

    @Autowired
    private StandardRepo standardRepository;

    public String addBook(BookDTO bookDTO) {
        Book book = mapToEntity(bookDTO);
        bookRepository.save(book);
        return "Success";
    }

    public BookDTO getBookById(Long id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found"));
        return mapToDTO(book);
    }

    public List<BookDTO> getAllBooks() {
        return bookRepository.findAll().stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    public List<BookDTO> getBooksByCategory(Long categoryId) {
        return bookRepository.findByCategoryId(categoryId).stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    public List<BookDTO> getBooksByStandard(Long standardId) {
        return bookRepository.findByStandardId(standardId).stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    public BookDTO updateBook(Long id, BookDTO bookDTO) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found"));
        book.setId(bookDTO.getId());
        book.setTitle(bookDTO.getTitle());
        book.setCondition(bookDTO.getCondition());
        book.setPurpose(bookDTO.getPurpose());
        book.setActualPrice(bookDTO.getActualPrice());
        book.setSellingPrice(bookDTO.getSellingPrice());

        Category category = categoryRepository.findById(bookDTO.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found,Please add the required Category"));
        book.setCategory(category);

        Standard standard = standardRepository.findById(bookDTO.getStandardId())
                .orElseThrow(() -> new RuntimeException("Standard not found,Please add the required Standard"));
        book.setStandard(standard);

        bookRepository.save(book);
        return mapToDTO(book);
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    public void deleteAllBooks() {
        bookRepository.deleteAll();
    }

    private BookDTO mapToDTO(Book book) {
        BookDTO bookDTO = new BookDTO();
        bookDTO.setId(book.getId());
        bookDTO.setTitle(book.getTitle());
        bookDTO.setCategoryId(book.getCategory().getId());
        bookDTO.setStandardId(book.getStandard().getId());
        bookDTO.setCondition(book.getCondition());
        bookDTO.setPurpose(book.getPurpose());
        bookDTO.setActualPrice(book.getActualPrice());
        bookDTO.setSellingPrice(book.getSellingPrice());
        return bookDTO;
    }

    private Book mapToEntity(BookDTO bookDTO) {
        Book book = new Book();
        book.setId(bookDTO.getId());
        book.setTitle(bookDTO.getTitle());
        book.setCondition(bookDTO.getCondition());
        book.setPurpose(bookDTO.getPurpose());
        book.setActualPrice(bookDTO.getActualPrice());
        book.setSellingPrice(bookDTO.getSellingPrice());

        Category category = categoryRepository.findById(bookDTO.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found"));
        book.setCategory(category);

        Standard standard = standardRepository.findById(bookDTO.getStandardId())
                .orElseThrow(() -> new RuntimeException("Standard not found"));
        book.setStandard(standard);

        return book;
    }
}
