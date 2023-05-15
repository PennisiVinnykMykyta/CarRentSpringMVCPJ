package com.project.services.implementations;

import com.project.dto.BookDTO;
import com.project.dto.CarDTO;
import com.project.entities.Book;
import com.project.entities.Car;
import com.project.entities.User;
import com.project.mappers.BookMapper;
import com.project.repositories.BookRepository;
import com.project.repositories.CarRepository;
import com.project.repositories.UserRepository;
import com.project.services.BookService;
import com.project.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImplementation implements BookService {

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private BookMapper bookMapper;
    @Autowired
    CarService carService;

    private BookDTO bookDTO = new BookDTO();
    @Autowired
    private UserRepository userRepository;
    private Book book;
    private User user;

    public String checkDates(String start, String end){

        if(!start.isEmpty() && !end.isEmpty()){
            LocalDate startDate = LocalDate.parse(start);
            LocalDate endDate = LocalDate.parse(end);

            if(startDate.isAfter(endDate)){
                return "Error: starting date cannot be after drop-off date";
            }else if(startDate.isBefore(LocalDate.now().plusDays(2))){
                return "Error: starting date must be selected at least 2 days prior to the current date";
            }else{
                return "";
            }

        }else{
            return "Error: both dates need to be selected";
        }
    }

    public String bookController(String error){
        if(error.equals("")){
            return "availableCars";
        }else{
            return "addBook";
        }
    }

    public BookServiceImplementation(BookRepository bookRepository){
        this.bookRepository=bookRepository;
    }


    @Override
    public List<BookDTO> findAllUserBooks(int userID){
        user = userRepository.findById(userID);
        List<Book> bookList = user.getBookings();
        List<BookDTO> bookDTOList = new ArrayList<>();
        for(Book book : bookList){
            bookDTO = bookMapper.fromBookToBookDTO(book);
            bookDTOList.add(bookDTO);
        }
        return  bookDTOList;
    }
    @Override
    public BookDTO findBookById(int id){
        book = bookRepository.findById(id);
        bookDTO = bookMapper.fromBookToBookDTO(book);
        return bookDTO;
    }

    @Override
    public List<BookDTO> findAllBooks(){
        List<Book> bookList = bookRepository.findAll();
        List<BookDTO> bookDTOList = new ArrayList<>();
        for(Book book : bookList){
            bookDTO = bookMapper.fromBookToBookDTO(book);
            bookDTOList.add(bookDTO);
        }
        return  bookDTOList;
    }

    @Override
    public List<CarDTO> getConflictingBookings(String start, String end){
        if(start.isEmpty()){
            return null;
        }else{
            LocalDate startDate = LocalDate.parse(start);
            LocalDate endDate = LocalDate.parse(end);

            List<Book> conflictingBookings = bookRepository.conflictingBookings(startDate,endDate);
            List<BookDTO> bookDTOList = new ArrayList<>();

            int carID;
            List<Integer> bookedCarsIDS = new ArrayList<>();

            for (Book book : conflictingBookings) {
                carID = book.getCar().getId();
                bookedCarsIDS.add(carID);
            }

            return  carService.availableCars(bookedCarsIDS);
        }
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
