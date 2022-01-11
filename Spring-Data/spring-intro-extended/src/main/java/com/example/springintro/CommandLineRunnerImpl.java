package com.example.springintro;

import com.example.springintro.model.entity.Book;
import com.example.springintro.model.entity.enums.AgeRestriction;
import com.example.springintro.model.entity.enums.EditionType;
import com.example.springintro.service.AuthorService;
import com.example.springintro.service.BookService;
import com.example.springintro.service.CategoryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {

    private final CategoryService categoryService;
    private final AuthorService authorService;
    private final BufferedReader bufferedReader;
    private final BookService bookService;

    public CommandLineRunnerImpl(CategoryService categoryService, AuthorService authorService, BufferedReader bufferedReader, BookService bookService) {
        this.categoryService = categoryService;
        this.authorService = authorService;
        this.bufferedReader = bufferedReader;

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
//        printAllBooksOrderedByAuthor("George", "Powell");


        System.out.println("select ex");
        int exNum = Integer.parseInt(bufferedReader.readLine());


        switch (exNum) {
            case 1:
                printTitles();
            case 2:
                printGoldenBooks();
            case 3:
                printPrices();
            case 4:
                printNotReleasedBooks();
            case 5:
                printReleasedBeforeDate();
            case 6:
                printNameThatEndsWith();
            case 7:
                printContaining();
            case 8:
                bookTItles();
            case 9: printLength();
            case 10: printCopies();
            case 11: print();
            case 99: test();
            case 12: printIncreasedCopies();
            case 13: removeBooks();
            case 14: procedure();

        }


    }

    private void procedure() throws IOException {

        String fName = bufferedReader.readLine();
        String lName = bufferedReader.readLine();

        System.out.println(authorService.totalBooksByAuthor(fName, lName));


    }

    private void removeBooks() throws IOException {

        int copies = Integer.parseInt(bufferedReader.readLine());
        System.out.println(bookService.removeBooks(copies));

    }

    private void printIncreasedCopies() throws IOException {

        LocalDate localDate = LocalDate.parse(bufferedReader.readLine(), DateTimeFormatter.ofPattern("dd MMM yyyy"));
        int newCopies = Integer.parseInt(bufferedReader.readLine());

        System.out.println(bookService.increaseCopies(localDate, newCopies));
    }

    private void test() {
        bookService.changePrice(1L);
    }

    private void print() throws IOException {

        String book = bufferedReader.readLine();
        System.out.println(bookService.print(book));

    }

    private void printCopies() throws IOException {

        String input = bufferedReader.readLine();

        authorService.findCopies()
        .forEach(System.out::println);

    }

    private void printLength() throws IOException {

        System.out.println("length");
        int len = Integer.parseInt(bufferedReader.readLine());
        System.out.println(bookService.findCount(len));

    }

    private void bookTItles() throws IOException {
        String name = bufferedReader.readLine();
        bookService.printTitles(name)
        .forEach(System.out::println);


    }

    private void printContaining() throws IOException {

        String s = bufferedReader.readLine();

        bookService.printAllStr(s.toUpperCase())
                .forEach(System.out::println);

    }

    private void printNameThatEndsWith() throws IOException {

        System.out.println("Enter name");
        String name = bufferedReader.readLine();

        authorService.printNames(name)
                .forEach(System.out::println);

    }

    private void printReleasedBeforeDate() throws IOException {

        LocalDate localDate = LocalDate.parse(bufferedReader.readLine(), DateTimeFormatter.ofPattern("dd-MM-yyyy"));

        bookService.printBeforeDate(localDate)
                .forEach(System.out::println);

    }

    private void printNotReleasedBooks() throws IOException {

        System.out.println("Enter year");
        int year = Integer.parseInt(bufferedReader.readLine());
        bookService.findAllNotReleasedInYear(year)
                .forEach(System.out::println);

    }

    private void printPrices() {

        bookService.printPrices(BigDecimal.valueOf(5), BigDecimal.valueOf(40))
                .forEach(System.out::println);

    }

    private void printGoldenBooks() {

        EditionType editionType = EditionType.GOLD;
        bookService.findAllGoldenBook(editionType, 5000)
                .forEach(System.out::println);

    }

    private void printTitles() throws IOException {

        System.out.println("enter age restriction");
        String line = bufferedReader.readLine();

        AgeRestriction ageRestriction = AgeRestriction.valueOf(line.toUpperCase());

        bookService.findAllBookTitlesAgeRestr(ageRestriction)
                .forEach(System.out::println);

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
