package com.project.services.implementations;

import com.project.entities.Book;
import com.project.repositories.BookRepository;
import com.project.services.BookService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class BookServiceImplementation implements BookService {

    private BookRepository bookRepository;
    private Book book;

    public BookServiceImplementation(BookRepository bookRepository){
        this.bookRepository=bookRepository;
    }

    @Override
    public Book findBookById(int id){
        book = bookRepository.findById(id);
        return book;
    }

    @Override
    public List<Book> findAllBooks(){
        List<Book> bookList = bookRepository.findAll();
        return  bookList;
    }

    @Override
    public List<Book> getConflictingBookings(LocalDate start, LocalDate end){
        List<Book> conflictingBookings = bookRepository.conflictingBookings(start,end);
        return  conflictingBookings;
    }

    @Override
    public void deleteById(int id){
        bookRepository.deleteById(id);
    }

    @Override
    public void saveOrUpdateBook(Book book){
        bookRepository.saveOrUpdateBook(book);
    }
}
