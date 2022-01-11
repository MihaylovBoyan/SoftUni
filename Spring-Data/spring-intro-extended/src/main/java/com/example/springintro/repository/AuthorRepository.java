package com.example.springintro.repository;

import com.example.springintro.model.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;

import java.util.List;

public interface AuthorRepository extends BaseRepository<Author> {

    @Query("select a from Author a order by a.books.size desc")
    List<Author> findAllByBooksSizeDesc();

    List<Author> findAllByFirstNameEndsWith(String lastName);

    @Query(value = "call total_books_by_author(:first_name, :last_name);", nativeQuery = true)
    int totalBooksByAuthor(String first_name, String last_name);



}
