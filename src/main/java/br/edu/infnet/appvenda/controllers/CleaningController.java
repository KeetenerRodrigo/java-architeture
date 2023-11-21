package br.edu.infnet.appvenda.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.edu.infnet.appvenda.models.domains.Cleaning;
import br.edu.infnet.appvenda.models.services.CleaningService;

@Controller
public class CleaningController {

    @Autowired
    private AppController appController;

    @Autowired
    private CleaningService cleaningService;

    @GetMapping(value = "/cleaning/search")
    public String search(Model model, String searchField){

        List<Cleaning> cleanings = cleaningService.findByName(searchField);

        if(cleanings != null && !cleanings.isEmpty()) {

            model.addAttribute("list", cleanings);
            model.addAttribute("title", null);

            return appController.showHome(model);

        } 

        return "redirect:/cleaning/list";

    }

    @GetMapping(value = "/cleaning/{id}/delete")
    public String delete(@PathVariable Integer id) {

        cleaningService.delete(id);

        return "redirect:/cleaning/list";

    }

    @GetMapping(value = "/cleaning/list")
    public String getSellers(Model model) {

        model.addAttribute("route", "cleaning");
        model.addAttribute("title", "Produtos de Limpeza");
        model.addAttribute("list", cleaningService.findAll());

        return appController.showHome(model);

    }

}
