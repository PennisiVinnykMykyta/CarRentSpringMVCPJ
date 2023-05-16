package com.project.controllers;

import com.project.dto.BookDTO;
import com.project.dto.CarDTO;
import com.project.dto.UserDTO;
import com.project.services.BookService;
import com.project.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping(value = "/book")
public class BookController {
    @Autowired
    BookService bookService;
    @Autowired
    UserService userService;

    @RequestMapping(value= "/bookList" , method = RequestMethod.GET)
    public String bookList(HttpServletRequest request, Model model){
        int userID = Integer.parseInt(request.getParameter("userID"));
        UserDTO userDTO = userService.getUserById(userID);
        model.addAttribute("user",userDTO);
        List<BookDTO> bookList = bookService.findAllUserBooks(userID);
        model.addAttribute("bookList",bookList);

        return "bookList";
    }

    @GetMapping(value = "/addBook")
    public String bookForm(HttpServletRequest request, Model model){
        UserDTO userDTO = userService.getUserById(Integer.parseInt(request.getParameter("userID")));
        model.addAttribute("user", userDTO);

        return "addBook";
    }

    @RequestMapping(value = "/homepage" , method = RequestMethod.GET)
    public String userHomepage(HttpServletRequest request){
        UserDTO userDTO = userService.getUserById(Integer.parseInt(request.getParameter("userID")));
        return "redirect:/user/homepage";
    }

    @PostMapping(value = "/selectCar")
    public String carSelection(HttpServletRequest request, Model model){
        int userID = Integer.parseInt(request.getParameter("userID"));
        UserDTO userDTO = userService.getUserById(userID);
        model.addAttribute("user",userDTO);

        String startDate = request.getParameter("startDate");
        String endDate = request.getParameter("endDate");

        model.addAttribute("startDate",startDate);
        model.addAttribute("endDate",endDate);

        String error = bookService.checkDates(startDate,endDate);
        model.addAttribute("error",error);

       List<CarDTO> availableCars = bookService.getConflictingBookings(startDate, endDate);
       model.addAttribute("carList",availableCars);

        return bookService.bookController(error);

    }

    @PostMapping(value="/saveOrUpdateBook")
    public String saveOrChangeBook(HttpServletRequest request, Model model){
        int userID = Integer.parseInt(request.getParameter("userID"));
        UserDTO userDTO = userService.getUserById(userID);
        model.addAttribute("user",userDTO);

//need to complete add car first
        return "redirect:/user/homepage";
    }
}
