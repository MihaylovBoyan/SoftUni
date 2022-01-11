package com.example.springintro.service;

import com.example.springintro.model.entity.Book;
import com.example.springintro.model.entity.enums.AgeRestriction;
import com.example.springintro.model.entity.enums.EditionType;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public interface BookService {
    void seedBooks() throws IOException;

    Set<Book> findAllBooksAfterYear(int year);

    List<String> findAllAuthorsWithBooksBeforeYear(int year);

    List<String> findAllBooksByAuthor(String firstName, String lastName);

    List<String> findAllBookTitlesAgeRestr(AgeRestriction ageRestriction);

    List<String> findAllGoldenBook(EditionType editionType, Integer copies);

    List<String> printPrices(BigDecimal first, BigDecimal second);

    List<String> findAllNotReleasedInYear(int year);

    List<String> printBeforeDate(LocalDate localDate);

    List<String> printAllStr(String toUpperCase);

    List<String> printTitles(String name);

    int findCount(int len);


    String print(String book);

    void changePrice(long bookId);

    int increaseCopies(LocalDate localDate, int newCopies);

    int removeBooks(int copies);
}
