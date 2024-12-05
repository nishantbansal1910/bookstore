package com.personal.bookstore.reposervice;

import org.springframework.data.jpa.repository.JpaRepository;

public abstract class AbstractReposervice<T, U> {

    public abstract JpaRepository<T, U> getRepo();

}
