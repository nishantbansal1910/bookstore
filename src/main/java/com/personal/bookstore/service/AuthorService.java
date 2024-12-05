package com.personal.bookstore.service;

import com.personal.bookstore.entity.Author;
import com.personal.bookstore.entity.Books;
import com.personal.bookstore.model.request.CreateBookRequest;
import com.personal.bookstore.reposervice.AbstractReposervice;
import com.personal.bookstore.reposervice.AuthorReposervice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {

    @Autowired
    private AuthorReposervice authorReposervice;

    public void createAuthorIfNotPresent(final Books books, final CreateBookRequest createBookRequest){
        if(authorReposervice.getAuthorByName(createBookRequest.getAuthorName()).isPresent()){
            books.setAuthor(authorReposervice.getAuthorByName(createBookRequest.getAuthorName()).get());
        }
        else{
            Author author = Author.builder().name(createBookRequest.getAuthorName()).build();
            author = authorReposervice.createAuthor(author);
            books.setAuthor(author);
        }
    }
}
