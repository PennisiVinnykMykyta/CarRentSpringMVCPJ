package com.project.controllers;

import com.project.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller //indentifica questa classe come controller e quindi andrà a gestire le chiamate
public class LoginController {

    @Autowired
    UserService userService;

    @GetMapping(value = "/")
    public String loginPage() {
        return "redirect:/user/loggedIn";
    }

   @RequestMapping(value = {"/login"} ,method = RequestMethod.GET)
    public String loginPageReload( Model model){
        return "login";
    }

}