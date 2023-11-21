package br.edu.infnet.appvenda.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.edu.infnet.appvenda.models.domains.Pharmaceutical;
import br.edu.infnet.appvenda.models.services.PharmaceuticalService;

@Controller
public class PharmaceuticalController {

    @Autowired
    private AppController appController;

    @Autowired
    private PharmaceuticalService pharmaceuticalService;

    @GetMapping(value = "/pharmaceutical/search")
    public String search(Model model, String searchField){

        List<Pharmaceutical> pharmaceutical = pharmaceuticalService.findByName(searchField);

        if(pharmaceutical != null && !pharmaceutical.isEmpty()) {

            model.addAttribute("list", pharmaceutical);
            model.addAttribute("title", null);

            return appController.showHome(model);

        } 

        return "redirect:/pharmaceutical/list";

    }

    @GetMapping(value = "/pharmaceutical/{id}/delete")
    public String delete(@PathVariable Integer id) {

        pharmaceuticalService.delete(id);

        return "redirect:/pharmaceutical/list";

    }

    @GetMapping(value = "/pharmaceutical/list")
    public String getPharmaceuticals(Model model) {

        model.addAttribute("route", "pharmaceutical");
        model.addAttribute("title", "Produtos farmacêuticos");
        model.addAttribute("list", pharmaceuticalService.findAll());

        return appController.showHome(model);

    }

}
