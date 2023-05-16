package com.project.repositories;

import com.project.entities.Car;
import java.util.List;

public interface CarRepository {

    void deleteById(int id);
    void saveOrUpdateCar(Car car);
    List<Car> findAll();
    Car findById(int id);
    List<Car> availableCars(List<Integer> BookedCars);

}
