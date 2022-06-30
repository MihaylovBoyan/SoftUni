package com.example.mobile.web;

import com.example.mobile.model.dto.BookDto;
import com.example.mobile.service.BooksService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BooksController {

    private final BooksService booksService;

    public BooksController(BooksService booksService) {
        this.booksService = booksService;
    }

    @GetMapping
    public ResponseEntity<List<BookDto>> getAllBooks(){
        List<BookDto> allBooks = booksService.getAllBooks();
        return ResponseEntity.ok(allBooks);
    }


}
