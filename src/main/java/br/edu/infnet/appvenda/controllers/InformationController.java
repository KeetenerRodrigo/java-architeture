package br.edu.infnet.appvenda.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.infnet.appvenda.models.domains.Information;
import br.edu.infnet.appvenda.models.services.InformationService;

@Controller
public class InformationController {

    @Autowired
    private AppController appController;
    
    @Autowired
    private InformationService informationService;

    @PostMapping(value = "/information/insert")
    public String insert(Information information){

		informationService.insert(information);

        return "redirect:/";

    }

    @GetMapping(value = "/informations")
    public String getPharmaceuticals(Model model) {

        model.addAttribute("route", "information");
        model.addAttribute("title", "Informações");
        model.addAttribute("informations", informationService.findAll());

        return appController.showHome(model);

    }

}
