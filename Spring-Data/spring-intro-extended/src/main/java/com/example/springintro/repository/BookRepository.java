package com.example.springintro.repository;

import com.example.springintro.model.entity.Author;
import com.example.springintro.model.entity.Book;
import com.example.springintro.model.entity.enums.AgeRestriction;
import com.example.springintro.model.entity.enums.EditionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    Set<Book> findAllByReleaseDateAfter(LocalDate releaseDate);

    List<Book> findAllByReleaseDateBefore(LocalDate releaseDate);

    List<Book> findAllByAuthor_FirstNameAndAuthor_LastNameOrderByReleaseDateDescTitle(String firstName, String lastName);

    List<Book> findAllByAgeRestriction(AgeRestriction ageRestriction);

    List<Book> findAllByEditionTypeAndCopiesLessThan(EditionType editionType, Integer copies);

    List<Book> findAllByPriceLessThanOrPriceGreaterThan(BigDecimal price, BigDecimal price2);

    List<Book> findAllByReleaseDateAfterOrReleaseDateBefore(LocalDate releaseDate, LocalDate releaseDate2);

    List<Book> findAllByTitleContaining(String title);

    List<Book> findAllByAuthor_LastNameStartsWith(String authorLastName);

    @Query("SELECT count (b) FROM Book b WHERE length(b.title) > :length ")
    int countOfBooks(int length);


    Book findAllByTitle(String title);

    @Procedure("change_book_price_by_id")
    void changeBookPriceById(Long book_id);

    @Modifying
    @Query("update Book b set b.copies = b.copies + :newCopies where b.releaseDate > :date ")
    int updateAfterDate(LocalDate date, int newCopies);

    @Modifying
    int removeAllByCopiesLessThan(int copies);

}
