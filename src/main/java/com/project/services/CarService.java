package com.project.services;

import com.project.entities.Car;

import java.util.List;

public interface CarService {

    public Car findCarById(int id);
    public List<Car> findAllCars();
    public List<Car> availableCars(List<Integer> BookedCars);
    public void deleteById(int id);
    public void saveOrUpdateCar(Car car);
}
