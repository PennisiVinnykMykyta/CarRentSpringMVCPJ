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

    public CarServiceImplementation(CarRepository userRepository){
        this.carRepository = userRepository;
    }

    public CarDTO findCarById(int id){
        Car car = carRepository.findById(id);

        return carMapper.fromCarToCarDTO(car);
    }
    public List<CarDTO> findAllCars(){
        List<Car> carList = carRepository.findAll();
        List<CarDTO> carDTOList = new ArrayList<>();
        CarDTO carDTO;
        for(Car car : carList){
            carDTO = carMapper.fromCarToCarDTO(car);
            carDTOList.add(carDTO);
        }
        return  carDTOList;
    }
    public List<CarDTO> availableCars(List<Integer> bookedCars){
        List<Car> availableCarList = carRepository.availableCars(bookedCars);
        List<CarDTO> carList = new ArrayList<>();
        for(Car car: availableCarList){
            CarDTO carDTO = carMapper.fromCarToCarDTO(car);
            carList.add(carDTO);
        }
        return  carList;
    }
    public void deleteById(int id){

        carRepository.deleteById(id);
    }
    public void saveOrUpdateCar(String carID,String model,String brand, String color, String numberPlate){
        Car car;

        if(carID == null || carID.isEmpty()){
            car = new Car(numberPlate,color,model,brand);
        }else{
            int id = Integer.parseInt(carID);
            car = new Car(id,numberPlate,color,model,brand);
        }

        carRepository.saveOrUpdateCar(car);
    }
}
