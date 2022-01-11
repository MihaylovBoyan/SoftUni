package com.example.springintro.service;

import com.example.springintro.model.entity.Author;
import com.example.springintro.model.entity.Book;
import com.example.springintro.model.entity.Category;
import com.example.springintro.model.entity.enums.AgeRestriction;
import com.example.springintro.model.entity.enums.EditionType;
import com.example.springintro.repository.BookRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final AuthorService authorService;
    private final CategoryService categoryService;

    public BookServiceImpl(BookRepository bookRepository, AuthorService authorService, CategoryService categoryService) {
        this.bookRepository = bookRepository;
        this.authorService = authorService;
        this.categoryService = categoryService;
    }

    @Override
    public void seedBooks() throws IOException {
        if (bookRepository.count() > 0) {
            return;
        }

        Files.readAllLines(Path.of("src/main/resources/files/books.txt"))
                .forEach(s -> {
                    String[] tokens = s.split("\\s+");

                    Book book = createBook(tokens);


                    bookRepository.save(book);
                });

    }

    @Override
    public Set<Book> findAllBooksAfterYear(int year) {


        return bookRepository.findAllByReleaseDateAfter(LocalDate.of(year, 1, 1));
    }

    @Override
    public List<String> findAllAuthorsWithBooksBeforeYear(int year) {
        return bookRepository
                .findAllByReleaseDateBefore(LocalDate.of(year, 1, 1))
                .stream()
                .map(book -> String.format("%s %s", book.getAuthor().getFirstName(), book.getAuthor().getLastName()))
                .distinct()
                .collect(Collectors.toList());
    }

    @Override
    public List<String> findAllBooksByAuthor(String firstName, String lastName) {
        return bookRepository.findAllByAuthor_FirstNameAndAuthor_LastNameOrderByReleaseDateDescTitle(firstName, lastName)
                .stream()
                .map(b -> String.format("%s %s", b.getTitle(), b.getReleaseDate()))
                .collect(Collectors.toList());
    }

    @Override
    public List<String> findAllBookTitlesAgeRestr(AgeRestriction ageRestriction) {
        return bookRepository.findAllByAgeRestriction(ageRestriction)
                .stream()
                .map(Book::getTitle)
                .collect(Collectors.toList());
    }

    @Override
    public List<String> findAllGoldenBook(EditionType editionType, Integer copies) {
        return bookRepository
                .findAllByEditionTypeAndCopiesLessThan(editionType, copies)
                .stream()
                .map(Book::getTitle)
                .collect(Collectors.toList());
    }

    @Override
    public List<String> printPrices(BigDecimal first, BigDecimal second) {
        return bookRepository.findAllByPriceLessThanOrPriceGreaterThan(first, second)
                .stream()
                .map(b -> String.format("%s %.2f", b.getTitle(), b.getPrice()))
                .collect(Collectors.toList());
    }

    @Override
    public List<String> findAllNotReleasedInYear(int year) {

        LocalDate lower = LocalDate.of(year, 1, 1);
        LocalDate upper = LocalDate.of(year, 12, 31);

        return bookRepository.findAllByReleaseDateAfterOrReleaseDateBefore(lower, upper)
                .stream().map(Book::getTitle)
                .collect(Collectors.toList());
    }

    @Override
    public List<String> printBeforeDate(LocalDate localDate) {

        return bookRepository.findAllByReleaseDateBefore(localDate)
                .stream()
                .map(b -> String.format("%s %s %.2f", b.getTitle(), b.getEditionType().toString(), b.getPrice()))
                .collect(Collectors.toList());
    }

    @Override
    public List<String> printAllStr(String toUpperCase) {
        return bookRepository.findAllByTitleContaining(toUpperCase)
                .stream()
                .map(Book::getTitle)
                .collect(Collectors.toList());
    }

    @Override
    public List<String> printTitles(String name) {
        return bookRepository.findAllByAuthor_LastNameStartsWith(name)
                .stream()
                .map(b -> String.format("%s %s %s", b.getTitle(), b.getAuthor().getFirstName(), b.getAuthor().getLastName()))
                .collect(Collectors.toList());
    }

    @Override
    public int findCount(int len) {
        return bookRepository.countOfBooks(len);
    }

    @Override
    public String print(String book) {
        return String.format("%s %s %s",
                bookRepository.findAllByTitle(book).getTitle(),
                bookRepository.findAllByTitle(book).getEditionType().toString(),
                bookRepository.findAllByTitle(book).getAgeRestriction().toString());
    }

    @Override
    @Transactional
    public void changePrice(long bookId) {
         bookRepository.changeBookPriceById(bookId);
    }

    @Override
    @Transactional
    public int increaseCopies(LocalDate localDate, int newCopies) {
        return bookRepository.updateAfterDate(localDate, newCopies) * newCopies;
    }

    @Override
    @Transactional
    public int removeBooks(int copies) {
        return bookRepository.removeAllByCopiesLessThan(copies);
    }


    private Book createBook(String[] tokens) {

        EditionType editionType = EditionType.values()[Integer.parseInt(tokens[0])];
        LocalDate releaseDate = LocalDate.parse(tokens[1], DateTimeFormatter.ofPattern("d/M/yyyy"));
        Integer copies = Integer.parseInt(tokens[2]);
        BigDecimal price = new BigDecimal(tokens[3]);
        AgeRestriction ageRestriction = AgeRestriction.values()[Integer.parseInt(tokens[4])];
        String title = Arrays.stream(tokens)
                .skip(5)
                .collect(Collectors.joining(" "));


        Author author = authorService.getRandomAuthor();
        Set<Category> categories = categoryService.getRandomCategories();

        return new Book(editionType, releaseDate, copies, price, ageRestriction, title
                , author, categories);

    }
}
