package com.project.mappers;

import com.project.dto.CarDTO;
import com.project.entities.Car;
import com.project.repositories.CarRepository;
import org.springframework.stereotype.Component;

@Component
public class CarMapper {

    private CarRepository carRepository;
    public CarMapper(CarRepository carRepository){
        this.carRepository = carRepository;
    }

    public CarDTO fromCarToCarDTO(Car car){
        int id = car.getId();
        String numberPlate = car.getNumberPlate();
        String color = car.getColor();
        String model = car.getModel();
        String brand = car.getBrand();

        CarDTO carDTO = new CarDTO(id,numberPlate,color,model,brand);
        return  carDTO;
    }

    public Car fromCarDTOToCar(CarDTO carDTO){
        int id = carDTO.getId();
        String numberPlate = carDTO.getNumberPlate();
        String color = carDTO.getColor();
        String model = carDTO.getModel();
        String brand = carDTO.getBrand();

        Car car = new Car(id,numberPlate,color,model,brand);
        return  car;
    }
}
