package com.project.services;

import com.project.dto.CarDTO;
import com.project.entities.Car;

import java.util.List;

public interface CarService {

    Car findCarById(int id);
    List<Car> findAllCars();
    List<CarDTO> availableCars(List<Integer> BookedCars);
    void deleteById(int id);
    void saveOrUpdateCar(String carID,String model,String brand, String color, String numberPlate);
}
