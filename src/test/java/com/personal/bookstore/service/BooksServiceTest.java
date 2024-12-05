package com.personal.bookstore.service;

import com.personal.bookstore.reposervice.BooksReposervice;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class BooksServiceTest {

    @Mock
    private BooksReposervice booksReposervice;

    @InjectMocks
    private BooksService booksService;

    @Test
    public void fetchBooksTest(){

    }
}
