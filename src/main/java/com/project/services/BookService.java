package com.project.services;

import com.project.entities.Book;

import java.time.LocalDate;
import java.util.List;

public interface BookService {

    public Book findBookById(int id);
    public List<Book> findAllBooks();
    public List<Book> getConflictingBookings(LocalDate startDate, LocalDate endDate);
    public void deleteById(int id);
    public void saveOrUpdateBook(Book book);
}
