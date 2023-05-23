package com.project.repositories;

import com.project.entities.Book;

import java.time.LocalDate;
import java.util.List;

public interface BookRepository {

    void deleteById(int id);

    void saveOrUpdateBook(Book book);

    Book findById(int id);

    List<Book> findAll();

    List<Book> conflictingBookings(LocalDate start, LocalDate end);
}
