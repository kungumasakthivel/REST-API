package com.example.goodreads;

import java.util.ArrayList;

public interface BookRepository {
    ArrayList<Book> getBooks();

    Book getBookById(int bookId);

}
