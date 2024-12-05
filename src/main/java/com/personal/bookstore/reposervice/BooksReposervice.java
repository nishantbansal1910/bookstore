package com.personal.bookstore.reposervice;

import com.personal.bookstore.entity.Books;
import com.personal.bookstore.model.request.FetchBooksRequest;
import com.personal.bookstore.repository.IBooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BooksReposervice extends AbstractReposervice<Books, Long> {

    @Autowired
    private IBooksRepository booksRepository;

    @Override
    public JpaRepository<Books, Long> getRepo() {
        return booksRepository;
    }

    public List<Books> fetchBooks(final FetchBooksRequest fetchBooksRequest) throws Exception {
        try {
            return booksRepository.fetchBooksByFilter((fetchBooksRequest.getPage()-1)*fetchBooksRequest.getPerPage(),
                    fetchBooksRequest.getPerPage(),
                    fetchBooksRequest.getName(),
                    fetchBooksRequest.getAuthor(),
                    fetchBooksRequest.getCategory());
        }
        catch (Exception e){
            throw new RuntimeException("Not able to process request");
        }
    }

    public Optional<Books> fetchBook(final String name){
        try {
            return booksRepository.findByName(name);
        }
        catch (Exception e){
            throw new RuntimeException("Not able to process request");
        }
    }

    public Books createBook(final Books book){
        try {
            return booksRepository.save(book);
        }
        catch (Exception e){
            throw new RuntimeException("Not able to process request");
        }
    }
}
