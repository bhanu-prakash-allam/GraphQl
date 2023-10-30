package com.graphql.graphqldemo.controller;

import com.graphql.graphqldemo.model.Author;
import com.graphql.graphqldemo.model.Book;
import com.graphql.graphqldemo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class BookController {
    @Autowired
    BookService bookService;
    @SchemaMapping(typeName = "Query",value = "allBooks")
    public List<Book> getBooks()
    {
        List<Book> books = bookService.getBooks();
        return books;
    }
    @QueryMapping
    public Book bookById(@Argument Integer id) {
        return bookService.bookById(id);
    }
    @MutationMapping
    public Book updateBook(@Argument Integer id, @Argument String title) {
        return bookService.updateBook(id, title);
    }
    @MutationMapping
    public Book createBook(@Argument Book book) {
        return bookService.save(book);
    }
    @SchemaMapping(typeName = "Book",field = "authorById")
    public Author getauthor(@Argument Integer id)
    {
        return bookService.getAuthor(id);
    }
}
