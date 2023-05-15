package com.project.dto;

import com.project.entities.Car;
import com.project.entities.User;
import org.springframework.stereotype.Component;

import java.time.LocalDate;


public class BookDTO {

    private int id;
    private User user;
    private Car car;
    private LocalDate startDate;
    private LocalDate endDate;

    private Boolean valid;

    public Boolean getValid() {
        return valid;
    }

    public void setValid(Boolean valid) {
        this.valid = valid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public BookDTO(){}

    public BookDTO(int id, User user, Car car, LocalDate startDate, LocalDate endDate) {
        this.id = id;
        this.user = user;
        this.car = car;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public BookDTO(User user, Car car, LocalDate startDate, LocalDate endDate) {
        this.user = user;
        this.car = car;
        this.startDate = startDate;
        this.endDate = endDate;
    }
}
