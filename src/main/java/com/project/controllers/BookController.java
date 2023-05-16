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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

    @PostMapping(value = "/acceptBooking")
    public String acceptBooking(HttpServletRequest request, Model model){
        UserDTO userDTO = userService.getUserById(Integer.parseInt(request.getParameter("userID")));
        model.addAttribute("user", userDTO);

        bookService.acceptBooking(Integer.parseInt(request.getParameter("bookID")));

        model.addAttribute("bookList",bookService.findAllBooks());

        return "globalBookList";
    }

    @GetMapping(value = "/addBook")
    public String bookForm(HttpServletRequest request, Model model){
        UserDTO userDTO = userService.getUserById(Integer.parseInt(request.getParameter("userID")));
        model.addAttribute("user", userDTO);
        model.addAttribute("bookID",request.getParameter("bookID"));

        return "addBook";
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
       model.addAttribute("bookID",request.getParameter("bookID"));

        return bookService.errorCheck(error);

    }

    @PostMapping(value="/saveOrUpdateBook")
    public String saveOrChangeBook(HttpServletRequest request, RedirectAttributes redirectAttributes){
        int userID = Integer.parseInt(request.getParameter("userID"));
        UserDTO userDTO = userService.getUserById(userID);

        String startDate = request.getParameter("startDate");
        String endDate = request.getParameter("endDate");

        int carID = Integer.parseInt(request.getParameter("carID"));
        String bookID = request.getParameter("bookID");

        bookService.saveOrUpdateBook(userID,carID,bookID,startDate,endDate);


        redirectAttributes.addAttribute("email",userDTO.getEmail());
        redirectAttributes.addAttribute("password", userDTO.getPassword());

        return "redirect:/user/homepage";
    }

    @RequestMapping(value= "/globalBookList" , method = RequestMethod.GET)
    public String globalBookList(HttpServletRequest request, Model model){
        UserDTO userDTO = userService.getUserById(Integer.parseInt(request.getParameter("userID")));
        model.addAttribute("user",userDTO);

        List<BookDTO> bookList = bookService.findAllBooks();
        model.addAttribute("bookList",bookList);

        return "globalBookList";
    }

    @PostMapping(value="/deleteLocal")
    public String deleteBook(HttpServletRequest request, Model model){

        int bookID = Integer.parseInt(request.getParameter("deleteID"));
        bookService.deleteById(bookID);

        UserDTO userDTO = userService.getUserById(Integer.parseInt(request.getParameter("userID")));

        model.addAttribute("user",userDTO);
        model.addAttribute("bookList",userDTO.getBookList());
        return "bookList";
    }
    @PostMapping(value="/deleteGlobal")
    public String deleteBookGlobal(HttpServletRequest request, Model model){
        UserDTO userDTO = userService.getUserById(Integer.parseInt(request.getParameter("userID")));

        int bookID = Integer.parseInt(request.getParameter("deleteID"));
        bookService.deleteById(bookID);

        model.addAttribute("user",userDTO);
        model.addAttribute("bookList",bookService.findAllBooks());
        return "globalBookList";
    }
}

