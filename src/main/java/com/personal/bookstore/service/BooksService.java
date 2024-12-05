package com.personal.bookstore.service;

import com.personal.bookstore.entity.Books;
import com.personal.bookstore.model.request.CreateBookRequest;
import com.personal.bookstore.model.request.FetchBooksRequest;
import com.personal.bookstore.model.response.FetchBooksResponse;
import com.personal.bookstore.reposervice.BooksReposervice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BooksService {

    @Autowired
    private BooksReposervice booksReposervice;

    @Autowired
    private AuthorService authorService;

    public List<FetchBooksResponse> fetchBooks(final FetchBooksRequest fetchBooksRequest) throws Exception{
        return booksReposervice.fetchBooks(fetchBooksRequest).stream().map(books -> FetchBooksResponse.builder()
                .id(books.getId())
                .category(books.getCategory())
                .price(books.getPrice())
                .stock(books.getStock())
                .name(books.getName())
                .build()).collect(Collectors.toList());
    }

    public String createBook(final CreateBookRequest createBookRequest) throws Exception {
        if(booksReposervice.fetchBook(createBookRequest.getName()).isPresent()) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "this book is already present");
        }
        final Books book = Books.builder().name(createBookRequest.getName()).price(createBookRequest.getPrice())
                .stock(createBookRequest.getStock()).category(createBookRequest.getCategory()).build();
        authorService.createAuthorIfNotPresent(book, createBookRequest);
        booksReposervice.createBook(book);
        return "book created";
    }
}
