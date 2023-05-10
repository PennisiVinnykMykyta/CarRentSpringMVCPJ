package com.project.repositories;

import com.project.entities.Car;
import java.util.List;

public interface CarRepository {

    public void deleteById(int id);
    public void saveOrUpdateCar(Car car);
    public List<Car> findAll();
    public Car findById(int id);
    public List<Car> availableCars(List<Integer> BookedCars);

}
