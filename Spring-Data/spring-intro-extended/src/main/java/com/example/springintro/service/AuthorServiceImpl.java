package com.example.springintro.service;

import com.example.springintro.model.entity.Author;
import com.example.springintro.model.entity.Book;
import com.example.springintro.repository.AuthorRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }


    @Override
    public void seedAuthors() throws IOException {

        if (authorRepository.count() > 0) {
            return;
        }

        Files.readAllLines(Path.of("src/main/resources/files/authors.txt"))
                .stream()
                .filter(a -> !a.isEmpty())
                .forEach(a -> {
                    String[] tokens = a.split("\\s+");
                    Author author = new Author();
                    author.setFirstName(tokens[0]);
                    author.setLastName(tokens[1]);

                    authorRepository.save(author);
                });


    }

    @Override
    public Author getRandomAuthor() {

        long randomId = ThreadLocalRandom
                .current().nextLong(1, authorRepository.count() + 1);

        return authorRepository.findById(randomId).orElse(null);
    }

    @Override
    public List<String> findAllAUthorsAndTheirBooks() {

        return authorRepository.findAllByBooksSizeDesc()
                .stream()
                .map(a -> String.format("%s %s %d", a.getFirstName(),
                        a.getLastName(), a.getBooks().size()))
                .collect(Collectors.toList());

    }

    @Override
    public List<String> printNames(String name) {

        return authorRepository.findAllByFirstNameEndsWith(name)
                .stream()
                .map(Author::getLastName)
                .collect(Collectors.toList());

    }

    @Override
    public List<String> findCopies() {

        return authorRepository
                .findAll()
                .stream()
                .map(a -> String.format("%s, %d",
                        a.getFirstName(),
                        a.getBooks()
                                .stream()
                                .map(Book::getCopies)
                                .reduce(Integer::sum)
                                .orElse(0)))
                .collect(Collectors.toList());

    }

    @Override
    @Transactional
    public int totalBooksByAuthor(String fame, String lName) {

        return authorRepository.totalBooksByAuthor(fame, lName);
    }
}
