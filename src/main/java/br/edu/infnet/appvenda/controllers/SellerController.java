package br.edu.infnet.appvenda.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.edu.infnet.appvenda.models.domains.Seller;
import br.edu.infnet.appvenda.models.services.SellerService;

@Controller
public class SellerController {

    @Autowired
    private AppController appController;

    @Autowired
    private SellerService sellerService;

    @GetMapping(value = "/seller/search")
    public String search(Model model, String searchField){

        List<Seller> sellers = sellerService.findByCpf(searchField);

        if(sellers != null && !sellers.isEmpty()) {

            model.addAttribute("list", sellers);
            model.addAttribute("title", null);

            return appController.showHome(model);

        } 

        return "redirect:/seller/list";

    }

    @GetMapping(value = "/seller/{id}/delete")
    public String delete(@PathVariable Integer id) {

        sellerService.delete(id);

        return "redirect:/seller/list";

    }

    @GetMapping(value = "/seller/list")
    public String getSellers(Model model) {

        model.addAttribute("route", "seller");
        model.addAttribute("title", "Vendedores");
        model.addAttribute("list", sellerService.findAll());

        return appController.showHome(model);

    }

}
