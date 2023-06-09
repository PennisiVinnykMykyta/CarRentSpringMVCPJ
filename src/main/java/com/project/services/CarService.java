package com.project.services;

import com.project.dto.CarDTO;

import java.util.List;

public interface CarService {

    CarDTO findCarById(int id);

    List<CarDTO> findAllCars();

    List<CarDTO> availableCars(List<Integer> BookedCars);

    void deleteById(int id);

    void saveOrUpdateCar(String carID, String model, String brand, String color, String numberPlate);
}
