package com.project.mappers;

import com.project.dto.CarDTO;
import com.project.entities.Car;
import org.springframework.stereotype.Component;

@Component
public class CarMapper {

    public CarDTO fromCarToCarDTO(Car car){
        int id = car.getId();
        String numberPlate = car.getNumberPlate();
        String color = car.getColor();
        String model = car.getModel();
        String brand = car.getBrand();

        return new CarDTO(id,numberPlate,color,model,brand);

    }

    public Car fromCarDTOToCar(CarDTO carDTO){
        int id = carDTO.getId();
        String numberPlate = carDTO.getNumberPlate();
        String color = carDTO.getColor();
        String model = carDTO.getModel();
        String brand = carDTO.getBrand();

        return new Car(id,numberPlate,color,model,brand);
    }
}
