package com.project.services;

import com.project.dto.BookDTO;
import com.project.dto.CarDTO;
import com.project.entities.Book;

import java.time.LocalDate;
import java.util.List;

public interface BookService {

    public BookDTO findBookById(int id);
    public List<BookDTO> findAllBooks();
    public List<CarDTO> getConflictingBookings(String startDate, String endDate);
    public void deleteById(int id);
    public void saveOrUpdateBook(Book book);
    public List<BookDTO> findAllUserBooks(int id);
    public String checkDates(String startDate, String endDate);

    public String bookController(String error);

}
