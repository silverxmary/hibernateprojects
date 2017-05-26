package com.eduit.spring.clase4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Marcelo on 05/04/2015.
 */
@Controller

public class LoginController {


    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(@RequestParam(value = "error", required = false) String error,
                              @RequestParam(value = "logout", required = false) String logout) {

        ModelAndView model = new ModelAndView();
        if (error != null) {
            model.addObject("error", "Usuario o contraseña inavalida");
        }

        if (logout != null) {
            model.addObject("msg", "Salio de la aplicacion de forma correcta");
        }
        model.setViewName("index");

        return model;

    }
}
