package com.eduit.spring.clase3.controller;

import com.eduit.spring.clase3.model.Articulo;
import com.eduit.spring.clase3.service.ArticuloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;


@Controller
public class ArticulosController {

    @Autowired
    private ArticuloService articuloService;

    @RequestMapping(value="/articulos" , method = RequestMethod.GET)
    public String init(ModelMap model){
       
        model.addAttribute("articulo", new Articulo());

        List<Articulo> articulos = articuloService.listarArticulos();
        model.addAttribute("articulos",articulos);

        return "articulos";
    }


    @RequestMapping(value = "/agregarArticulo", method = RequestMethod.POST)
    public ModelAndView addContact(@ModelAttribute("articulo")@Valid
                                   Articulo articulo, BindingResult result) {

        ModelAndView model = new ModelAndView("articulos");

        if(result.hasErrors()) {
            return model;
        }

        articuloService.salvarArticulo(articulo);
        List<Articulo> articulos = articuloService.listarArticulos();

        model.addObject("articulos",articulos);

        return model;
    }

}
