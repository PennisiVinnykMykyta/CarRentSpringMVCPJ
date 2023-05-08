package com.project.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller //indentifica questa classe come controller e quindi andrà a gestire le chiamate
public class indexController {



    //chiamata per gestire la pagina index
    @RequestMapping(value = "index") //annotazione che mappia la chiamata gestita dal controller, cioè il controller andrà a gestire tutte le chiamate che hanno index nel url della richiesta
    public String getWelcome(Model model){

        //eleemnti che visualizzeremo sulla nostra pagina
        model.addAttribute("saluto","Benvenuti nel sito Rent Car"); //nome e il contenuto
        model.addAttribute("intestazione","Seleziona i prodotti da acquistare");

        return "index"; //nome della pagina che andrà a restituire
    }

    @RequestMapping(value = "/") //chhiamata di default
    public String getWelcomeDefault(Model model){

        model.addAttribute("saluto","Il sito di Rent Car ti da il benvenuto");
        model.addAttribute("intestazione","Seleziona i prodotti da acquistare");
        return "index";
    }

}
