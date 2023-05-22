package com.project.controllers;

import com.project.dto.CarDTO;
import com.project.dto.UserDTO;
import com.project.services.CarService;
import com.project.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping(value = "/car")
public class CarController {
    @Autowired
    private UserService userService;
    @Autowired
    private CarService carService;


    @GetMapping(value = "/changeCar")
    public String changeCar(HttpServletRequest request, Model model){
        UserDTO userDTO = userService.getUserById(Integer.parseInt(request.getParameter("userID")));
        model.addAttribute("user",userDTO);

        CarDTO carDTO = carService.findCarById(Integer.parseInt(request.getParameter("carID")));
        model.addAttribute("car",carDTO);

        return "changeCar";
    }
    @PostMapping(value = "/delete")
    public String deleteCar(HttpServletRequest request, Model model){
        UserDTO userDTO = userService.getUserById(Integer.parseInt(request.getParameter("userID")));
        model.addAttribute("user",userDTO);
        int carID = Integer.parseInt(request.getParameter("deleteID"));
        carService.deleteById(carID);

        List<CarDTO> carList = carService.findAllCars();
        model.addAttribute("carList",carList);

        return "carList";
    }
    @GetMapping(value ="/carList")
    public String carList(HttpServletRequest request, Model model){
        UserDTO userDTO = userService.getUserById(Integer.parseInt(request.getParameter("userID")));
        model.addAttribute("user",userDTO);

        List<CarDTO> carList = carService.findAllCars();
        model.addAttribute("carList", carList);

        return "carList";
    }
    @GetMapping(value="/addCar")
    public String addCarForm( Model model){
        CarDTO carDTO = new CarDTO();
        model.addAttribute("car",carDTO);

        return "addCar";
    }

    @PostMapping(value = "/addOrChangeCar")
    public String saveOrChangeCar(@ModelAttribute("car") CarDTO car){

        carService.saveOrUpdateCar(car.getId(),car.getModel(),car.getBrand(),car.getColor(),car.getNumberPlate());

        return "redirect:/user/homepage";

    }

}
