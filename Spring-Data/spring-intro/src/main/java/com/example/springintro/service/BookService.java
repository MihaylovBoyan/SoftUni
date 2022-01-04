package com.example.springintro.service;

import com.example.springintro.model.entity.Book;

import java.io.IOException;
import java.util.List;
import java.util.Set;

public interface BookService {
    void seedBooks() throws IOException;

    Set<Book> findAllBooksAfterYear(int year);

    List<String> findAllAuthorsWithBooksBeforeYear(int year);

    List<String> findAllBooksByAuthor(String firstName, String lastName);
}
