package com.personal.bookstore.controller;

import com.personal.bookstore.model.request.CreateBookRequest;
import com.personal.bookstore.model.request.FetchBooksRequest;
import com.personal.bookstore.model.response.FetchBooksResponse;
import com.personal.bookstore.model.response.ServiceResponse;
import com.personal.bookstore.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/books")
public class BooksController {

    @Autowired
    private BooksService booksService;

    @GetMapping
    public ServiceResponse<List<FetchBooksResponse>> fetchBooks(
            @RequestParam(name = "page", defaultValue = "1", required = false) final Long page,
            @RequestParam(name = "perPage", defaultValue = "10", required = false) final Long perPage,
            @RequestParam(name = "name", required = false) final String name,
            @RequestParam(name = "author", required = false) final String author,
            @RequestParam(name = "category", required = false) final String category
    ) throws Exception {
        return new ServiceResponse<>(booksService.fetchBooks(FetchBooksRequest.builder()
                .page(page)
                .perPage(perPage)
                .author(author)
                .category(category)
                .name(name).build()));
    }

    @PostMapping
    public String createBook(@Valid @RequestBody final CreateBookRequest createBookRequest) throws Exception{
        return booksService.createBook(createBookRequest);
    }
}
