package com.project.controllers;

import com.project.dto.CarDTO;
import com.project.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping(value = "/car")
public class CarController {
    @Autowired
    private CarService carService;


    @GetMapping(value = "/changeCar")
    public String changeCar(HttpServletRequest request, Model model) {

        CarDTO carDTO = carService.findCarById(Integer.parseInt(request.getParameter("carID")));
        model.addAttribute("car", carDTO);

        return "changeCar";
    }

    @PostMapping(value = "/delete")
    public String deleteCar(HttpServletRequest request, Model model) {
        int carID = Integer.parseInt(request.getParameter("deleteID"));
        carService.deleteById(carID);

        List<CarDTO> carList = carService.findAllCars();
        model.addAttribute("carList", carList);

        return "carList";
    }

    @GetMapping(value = "/carList")
    public String carList(Model model) {

        List<CarDTO> carList = carService.findAllCars();
        model.addAttribute("carList", carList);

        return "carList";
    }

    @GetMapping(value = "/addCar")
    public String addCarForm(Model model) {
        CarDTO carDTO = new CarDTO();
        model.addAttribute("car", carDTO);

        return "addCar";
    }

    @PostMapping(value = "/addOrChangeCar")
    public String saveOrChangeCar(@ModelAttribute("car") CarDTO car) {

        carService.saveOrUpdateCar(car.getId(), car.getModel(), car.getBrand(), car.getColor(), car.getNumberPlate());

        return "redirect:/user/homepage";

    }

}
