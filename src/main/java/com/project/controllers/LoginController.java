package com.project.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller //indentifica questa classe come controller e quindi andrà a gestire le chiamate
public class LoginController {

    @GetMapping(value = "/")
    public String loginPage() {
        return "redirect:/user/loggedIn";
    }

    @RequestMapping(value = {"/login"}, method = RequestMethod.GET)
    public String loginPageReload() {
        return "login";
    }

}