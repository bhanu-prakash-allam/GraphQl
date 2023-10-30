package com.graphql.graphqldemo.repo;

import com.graphql.graphqldemo.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepo extends JpaRepository<Author,Integer> {
}
