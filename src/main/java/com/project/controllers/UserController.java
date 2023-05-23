package com.project.controllers;


import com.project.dto.UserDTO;
import com.project.services.BookService;
import com.project.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.text.ParseException;
import java.util.List;

@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    BookService bookService;

    @RequestMapping(value = "/deleteUser", method = RequestMethod.POST)
    public String deleteUser(HttpServletRequest request, Model model){

        int deleteID = Integer.parseInt(request.getParameter("deleteID"));
        bookService.deleteAllUserBookings(deleteID);
        String page = userService.deleteUserById(deleteID);

        List<UserDTO> userList = userService.getAllUsers();
        model.addAttribute("userList", userList);

        return page;
    }

    @RequestMapping(value ="/userList", method = RequestMethod.GET)
    public String userList(Model model){

        List<UserDTO> userList = userService.getAllUsers();
        model.addAttribute("userList",userList);
        return "userList";
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.GET)
    public String addUser(Model model){
        UserDTO userDTO = new UserDTO();
        model.addAttribute("userToChange",userDTO);
        return "addUser";
    }

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public String profile(HttpServletRequest request, Model model){
        int userID = Integer.parseInt(request.getParameter("userID"));
        UserDTO userDTO = userService.getUserById(userID);
        model.addAttribute("user",userDTO);
        return "showProfile";
    }

    @RequestMapping(value = "/changeProfile", method = RequestMethod.POST)
    public String changeProfile(HttpServletRequest request, Model model){

        int userToChangeID = Integer.parseInt(request.getParameter("userToChangeID"));
        UserDTO userToChangeDTO = userService.getUserById(userToChangeID);
        model.addAttribute("userToChange",userToChangeDTO);

        return "changeProfile";
    }

    @GetMapping(value = "/homepage")
    public String homepage(Principal principal, Model model) {

        String email =  principal.getName(); //request.getParameter("email"); for debug only!

        String direction = userService.getUserHomepage(email);

        UserDTO userDTO = userService.getUserByCredentials(email);

        model.addAttribute("user", userDTO);

        return direction;
    }

    @RequestMapping("/logout")
    public String logOut(){
        return "redirect:/login?logout";
    }

    @GetMapping("/loggedIn")
    public String test(){
        return "loggedIn";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveUser(@ModelAttribute("userToChange") UserDTO userToChange) throws ParseException {

        return userService.saveOrUpdateUser(userToChange);

    }
}
