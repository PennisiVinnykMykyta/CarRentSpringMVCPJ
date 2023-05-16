package com.project.mappers;

import com.project.dto.BookDTO;
import com.project.dto.CarDTO;
import com.project.dto.UserDTO;
import com.project.entities.Book;
import com.project.entities.Car;
import com.project.entities.User;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class BookMapper {

    public BookDTO fromBookToBookDTO(Book book){
        CarMapper carMapper = new CarMapper();
        UserMapper userMapper = new UserMapper();

        int id = book.getId();
        LocalDate startDate = book.getStartDate();
        LocalDate endDate = book.getEndDate();
        User user = book.getUser();
        Car car = book.getCar();

        UserDTO userDTO = userMapper.fromUserToDto(user);
        CarDTO carDTO =  carMapper.fromCarToCarDTO(car);

        return new BookDTO(id,userDTO,carDTO,startDate,endDate);

    }
}
