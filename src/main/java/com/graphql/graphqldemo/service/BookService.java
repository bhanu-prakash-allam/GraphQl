package com.graphql.graphqldemo.service;

import com.graphql.graphqldemo.exception.BookNotFoundException;
import com.graphql.graphqldemo.model.Author;
import com.graphql.graphqldemo.model.Book;
import com.graphql.graphqldemo.repo.AuthorRepo;
import com.graphql.graphqldemo.repo.BookRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BookService {

    @Autowired
    BookRepo bookRepository;
    @Autowired
    AuthorRepo authorRepo;

    public List<Book> getBooks()
    {
        List<Book> books = bookRepository.findAll();
       return  books;
    }
    public Book bookById(Integer id) {

        Optional<Book> book = bookRepository.findById(id);
        if(book.isPresent())
        {
            return bookRepository.findById(id).get();
        }
        throw new BookNotFoundException("book not available with id");
    }

    public Book updateBook(Integer id, String title) {
        Book book = bookRepository.findById(id).get();
        book.setTitle(title);
        bookRepository.save(book);
        return book;
    }

    public Book save(Book book) {
        return bookRepository.save(book);
    }

    public Author getAuthor(Integer id) {
        Optional<Author> author = authorRepo.findById(id);
        if(author.isPresent())
            return author.get();
        else
            throw new RuntimeException("Author not found");
    }
}
