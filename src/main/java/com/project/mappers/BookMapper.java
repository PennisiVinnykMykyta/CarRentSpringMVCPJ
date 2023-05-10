package com.project.mappers;

import com.project.dto.BookDTO;
import com.project.entities.Book;
import com.project.entities.Car;
import com.project.entities.User;
import com.project.repositories.BookRepository;

import java.time.LocalDate;

public class BookMapper {

    private BookRepository bookRepository;

    public BookMapper(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    public BookDTO fromBookToBookDTO(Book book){

        int id = book.getId();
        LocalDate startDate = book.getStartDate();
        LocalDate endDate = book.getEndDate();
        User user = book.getUser();
        Car car = book.getCar();

        BookDTO bookDTO = new BookDTO(id,user,car,startDate,endDate);

        return  bookDTO;


    }

    public Book fromBookDTOToBook(BookDTO bookDTO){
        int id = bookDTO.getId();
        LocalDate startDate = bookDTO.getStartDate();
        LocalDate endDate = bookDTO.getEndDate();
        User user = bookDTO.getUser();
        Car car = bookDTO.getCar();

        Book book = new Book(id,user,car,startDate,endDate);

        return  book;
    }
}
