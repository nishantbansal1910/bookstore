package com.personal.bookstore.reposervice;

import com.personal.bookstore.entity.Author;
import com.personal.bookstore.entity.Books;
import com.personal.bookstore.repository.IAuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthorReposervice extends AbstractReposervice<Author, Long>{

    @Autowired
    private IAuthorRepository authorRepository;

    public JpaRepository<Author, Long> getRepo(){return authorRepository;}

    public Author createAuthor(final Author author){
        try {
            return authorRepository.save(author);
        }
        catch (Exception e){
            throw new RuntimeException("Not able to process request");
        }
    }

    public Optional<Author> getAuthorByName(final String name){
        try {
            return authorRepository.findByName(name);
        }
        catch (Exception e){
            throw new RuntimeException("Not able to process request");
        }
    }
}
