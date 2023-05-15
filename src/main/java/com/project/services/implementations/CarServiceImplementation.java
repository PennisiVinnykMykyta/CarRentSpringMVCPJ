package com.project.services.implementations;

import com.project.dto.CarDTO;
import com.project.entities.Car;
import com.project.mappers.CarMapper;
import com.project.repositories.CarRepository;
import com.project.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarServiceImplementation implements CarService {

    @Autowired
    private CarRepository carRepository;
    @Autowired
    private CarMapper carMapper;

    private CarDTO carDTO;
    private Car car;

    public CarServiceImplementation(CarRepository userRepository){
        this.carRepository = userRepository;
    }

    public Car findCarById(int id){
        car = carRepository.findById(id);
        return car;
    }
    public List<Car> findAllCars(){
        List<Car> carList = carRepository.findAll();
        return  carList;
    }
    public List<CarDTO> availableCars(List<Integer> bookedCars){
        List<Car> availableCarList = carRepository.availableCars(bookedCars);
        List<CarDTO> carList = new ArrayList<>();
        for(Car car: availableCarList){
            carDTO = carMapper.fromCarToCarDTO(car);
            carList.add(carDTO);
        }
        return  carList;
    }
    public void deleteById(int id){
        carRepository.deleteById(id);
    }
    public void saveOrUpdateCar(Car car){
        carRepository.saveOrUpdateCar(car);
    }
}
