package com.project.services;

import com.project.dto.BookDTO;
import com.project.dto.CarDTO;
import com.project.entities.Book;

import java.time.LocalDate;
import java.util.List;

public interface BookService {

    BookDTO findBookById(int id);
    List<BookDTO> findAllBooks();
    List<CarDTO> getConflictingBookings(String startDate, String endDate);
    void deleteById(int id);
    void saveOrUpdateBook(Book book);
    List<BookDTO> findAllUserBooks(int id);
    String checkDates(String startDate, String endDate);

    String bookController(String error);

}
