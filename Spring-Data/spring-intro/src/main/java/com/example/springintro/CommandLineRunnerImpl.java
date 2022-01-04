package com.example.springintro;

import com.example.springintro.model.entity.Book;
import com.example.springintro.service.AuthorService;
import com.example.springintro.service.BookService;
import com.example.springintro.service.CategoryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {

    private final CategoryService categoryService;
    private final AuthorService authorService;
    private final BookService bookService;

    public CommandLineRunnerImpl(CategoryService categoryService, AuthorService authorService, BookService bookService) {
        this.categoryService = categoryService;
        this.authorService = authorService;
        this.bookService = bookService;
    }

    @Override
    public void run(String... args) throws Exception {
        categoryService.seedCategories();
//        authorService.seedAuthors();
//        bookService.seedBooks();
//
//        printAllBooksAfter2000(2000);
//        printAllAuthorsWithBooksBefore1990(1990);
   //     printALlAuthorsAndTheirBooks();
        printAllBooksOrderedByAuthor("George", "Powell");
    }

    private void printAllBooksOrderedByAuthor(String firstName, String lastName) {

        bookService.findAllBooksByAuthor(firstName, lastName)
        .forEach(System.out::println);


    }

    private void printALlAuthorsAndTheirBooks() {
        authorService.findAllAUthorsAndTheirBooks()
        .forEach(System.out::println);
    }

    private void printAllAuthorsWithBooksBefore1990(int year) {
        bookService.findAllAuthorsWithBooksBeforeYear(year)
                .forEach(System.out::println);
    }

    private void printAllBooksAfter2000(int year) {
        bookService.findAllBooksAfterYear(year)
                .stream()
                .map(Book::getTitle)
                .forEach(System.out::println);
    }
}
