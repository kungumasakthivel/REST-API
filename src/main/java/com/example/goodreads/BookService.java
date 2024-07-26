package com.example.goodreads;

import java.util.*;
import com.example.goodreads.Book;
import com.example.goodreads.BookRepository;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

class BookService implements BookRepository {
    private HashMap<Integer, Book> hmap = new HashMap<>();

    public BookService() {
        Book b1 = new Book(1, "Harry Porter", "image1.jpg");
        Book b2 = new Book(2, "Rise", "image2.jpg");
        Book b3 = new Book(3, "King", "image3.jpg");

        hmap.put(b1.getId(), b1);
        hmap.put(b2.getId(), b2);
        hmap.put(b3.getId(), b3);
    }

    @Override
    public ArrayList<Book> getBooks() {
        Collection<Book> booksCollection = hmap.values();
        ArrayList<Book> books = new ArrayList<>(booksCollection);
        return books;
    }

    @Override
    public Book getBookById(int bookId) {
        Book book = hmap.get(bookId);
        if(book == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return book;
    }

}