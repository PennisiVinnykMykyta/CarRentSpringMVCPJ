package com.project.repositories;

import com.project.entities.Book;

import java.time.LocalDate;
import java.util.List;

public interface BookRepository {

    public void deleteById(int id);
    public void saveOrUpdateBook(Book book);
    public Book findById(int id);
    public List<Book> findAll();
    public List<Book> conflictingBookings(LocalDate start, LocalDate end);
}
