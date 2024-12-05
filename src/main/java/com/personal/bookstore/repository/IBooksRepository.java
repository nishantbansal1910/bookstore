package com.personal.bookstore.repository;

import com.personal.bookstore.entity.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IBooksRepository extends JpaRepository<Books, Long>, JpaSpecificationExecutor<Books> {

    @Query(value = "SELECT b.* FROM books b LEFT JOIN author a ON b.author_id = a.id WHERE (?3 IS NULL or b.name = ?3) " +
            "AND (?5 IS NULL or b.category = ?5) AND (?4 IS NULL or a.name = ?4) " +
            "ORDER BY b.id LIMIT ?2 OFFSET ?1", nativeQuery = true)
    List<Books> fetchBooksByFilter(final Long offset,
                                   final Long limit,
                                   final String name,
                                   final String author,
                                   final String category);

    Optional<Books> findByName(final String name);
}
