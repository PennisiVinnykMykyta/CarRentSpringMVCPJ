package com.project.controllers;


import com.project.dto.UserDTO;
import com.project.entities.User;
import com.project.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    UserService userService;

    UserDTO userDTO;

    @RequestMapping(value = "/deleteUser", method = RequestMethod.POST)
    public String deleteUser(HttpServletRequest request, Model model){
        int userID = Integer.parseInt(request.getParameter("userID"));
        int deleteID = Integer.parseInt(request.getParameter("deleteID"));
        String page = userService.deleteUserById(deleteID);

        userDTO = userService.getUserById(userID);
        model.addAttribute("user",userDTO);
        List<UserDTO> userList = userService.getAllUsers();
        model.addAttribute("userList", userList);

        return page;
    }

    @RequestMapping(value ="/userList", method = RequestMethod.GET)
    public String userList(HttpServletRequest request, Model model){
        int userID = Integer.parseInt(request.getParameter("userID"));
        userDTO = userService.getUserById(userID);
        List<UserDTO> userList = userService.getAllUsers();
        model.addAttribute("user",userDTO);
        model.addAttribute("userList",userList);
        return "userList";
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.GET)
    public String addUser(HttpServletRequest request, Model model){
        int userID = Integer.parseInt(request.getParameter("userID"));
        userDTO = userService.getUserById(userID);
        model.addAttribute("user",userDTO);
        return "addUser";
    }

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public String profile(HttpServletRequest request, Model model){
        int userID = Integer.parseInt(request.getParameter("userID"));
        userDTO = userService.getUserById(userID);
        model.addAttribute("user",userDTO);
        return "showProfile";
    }

    @RequestMapping(value = "/changeProfile", method = RequestMethod.POST)
    public String changeProfile(HttpServletRequest request, Model model){
        int id = Integer.parseInt(request.getParameter("userID")); //se stiamo modifcando il nostro profilo entrambi gli id coincidono
        int userToChangeID = Integer.parseInt(request.getParameter("userToChangeID"));
        userDTO = userService.getUserById(id);
        UserDTO userToChangeDTO = userService.getUserById(userToChangeID);
        model.addAttribute("user",userDTO);
        model.addAttribute("userToChange",userToChangeDTO);
        return "changeProfile";
    }

    @GetMapping(value = "/homepage")
    public String homepage(HttpServletRequest request, Model model, RedirectAttributes redirectAttributes) {

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        String[] viewAndError = userService.getUserHomepage(email, password);
        String direction = viewAndError[0];
        String error = viewAndError[1];

        userDTO = userService.getUserByCredentials(email, password);

        model.addAttribute("user", userDTO);
        redirectAttributes.addAttribute("error",error);

        return direction;

    }

    @RequestMapping("/logout")
    public String logOut(RedirectAttributes redirectAttributes){
        redirectAttributes.addAttribute("error","");
        return "redirect:/login";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveUser(HttpServletRequest request,Model model){

        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String dateForm = request.getParameter("birthDate");
        String type = request.getParameter("type");
        int userID = Integer.parseInt(request.getParameter("userID"));
        int userToChangeID = Integer.parseInt(request.getParameter("userToChangeID"));

        String homepage = userService.saveOrUpdateUser(userID,userToChangeID,firstName,lastName,email,password,dateForm,type);

        userDTO = userService.getUserById(userID);
        model.addAttribute("user",userDTO);

        return homepage;
    }

}
