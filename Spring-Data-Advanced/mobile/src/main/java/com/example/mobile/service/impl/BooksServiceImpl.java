package com.example.mobile.service.impl;

import com.example.mobile.model.dto.AuthorDto;
import com.example.mobile.model.dto.BookDto;
import com.example.mobile.model.entity.BookEntity;
import com.example.mobile.repository.BookRepository;
import com.example.mobile.service.BooksService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BooksServiceImpl implements BooksService {

    private final BookRepository bookRepository;
    private final ModelMapper modelMapper;

    public BooksServiceImpl(BookRepository bookRepository, ModelMapper modelMapper) {
        this.bookRepository = bookRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<BookDto> getAllBooks() {
        return bookRepository.findAll()
                .stream()
                .map(this::asBook)
                .collect(Collectors.toList());
    }

    public BookDto asBook(BookEntity book){
        BookDto bookDTO = modelMapper.map(book, BookDto.class);
        AuthorDto authorDto = modelMapper.map(book.getAuthor(), AuthorDto.class);
        bookDTO.setAuthor(authorDto);
        return bookDTO;
    }

}
