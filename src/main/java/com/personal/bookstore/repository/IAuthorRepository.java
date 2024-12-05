package com.personal.bookstore.repository;

import com.personal.bookstore.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Objects;
import java.util.Optional;

@Repository
public interface IAuthorRepository extends JpaRepository<Author,Long>, JpaSpecificationExecutor<Author> {

    Optional<Author> findByName(final String name);
}
