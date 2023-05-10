package com.project.services.implementations;

import com.project.entities.Car;
import com.project.repositories.CarRepository;
import com.project.services.CarService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImplementation implements CarService {

    private CarRepository carRepository;
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
    public List<Car> availableCars(List<Integer> bookedCars){
        List<Car> availableCarList = carRepository.availableCars(bookedCars);
        return  availableCarList;
    }
    public void deleteById(int id){
        carRepository.deleteById(id);
    }
    public void saveOrUpdateCar(Car car){
        carRepository.saveOrUpdateCar(car);
    }
}
