package com.example.mobile;

import com.example.mobile.model.entity.AuthorEntity;
import com.example.mobile.model.entity.BookEntity;
import com.example.mobile.repository.AuthorRepository;
import com.example.mobile.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class BooksAppInit implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BooksAppInit(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {


        if(bookRepository.count() == 0 && authorRepository.count() == 0){
            initJovkov();
            initNikolaiHaitov();
            initDimitarTalev();
            initElinPelin();
            initVazov();
        }

    }

    private void initDimitarTalev() {
        initAuthor("Dimitar Talev", "TUTUN");
    }

    private void initElinPelin() {
        initAuthor("Elin Pelin", "Pijo i Pendo", "Qn bibiqn na lunata", "Pod lozata");
    }

    private void initVazov() {
        initAuthor("Ivan Vazov", "Prqporec i Gusla","Pod Igoto", "Tugite na bg");
    }

    private void initJovkov() {
        initAuthor("Yordan Yovkov", "Staroplaninski legendi", "chiflikat krai gradinata");
    }

    private void initNikolaiHaitov() {
        initAuthor("Nikolai Haitov", "Divi Razkazi");
    }

    private void initAuthor(String name, String... books) {
        AuthorEntity author = new AuthorEntity();
        author.setName(name);

        List<BookEntity> allBooks = new ArrayList<>();

        for (String book : books) {
            BookEntity aBook = new BookEntity();
            aBook.setAuthor(author);
            aBook.setTitle(book);
            aBook.setIsbn(UUID.randomUUID().toString());
            allBooks.add(aBook);
        }

        author.setBooks(allBooks);
        bookRepository.saveAll(allBooks);

    }
}
