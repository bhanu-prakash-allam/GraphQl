package com.graphql.graphqldemo.repo;

import com.graphql.graphqldemo.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepo extends JpaRepository<Book,Integer> {
}
