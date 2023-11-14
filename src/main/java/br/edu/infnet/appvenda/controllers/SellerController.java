package br.edu.infnet.appvenda.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.edu.infnet.appvenda.models.services.SellerService;

@Controller
public class SellerController {

    @Autowired
    private AppController appController;

    @Autowired
    private SellerService sellerService;

    @GetMapping(value = "/seller/{id}/delete")
    public String delete(@PathVariable Integer id) {

        sellerService.delete(id);

        return "redirect:/sellers";

    }

    @GetMapping(value = "/sellers")
    public String getSellers(Model model) {

        model.addAttribute("route", "vendedor");
        model.addAttribute("title", "Vendedores:");
        model.addAttribute("list", sellerService.findAll());

        return appController.showHome(model);

    }

}
