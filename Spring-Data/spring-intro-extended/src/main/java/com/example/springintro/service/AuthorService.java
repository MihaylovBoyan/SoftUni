package com.example.springintro.service;

import com.example.springintro.model.entity.Author;

import java.io.IOException;
import java.util.List;

public interface AuthorService {

    void seedAuthors() throws IOException;

    Author getRandomAuthor();

    List<String> findAllAUthorsAndTheirBooks();

    List<String> printNames(String name);


    List<String> findCopies();

    int totalBooksByAuthor(String fName, String lName);
}
