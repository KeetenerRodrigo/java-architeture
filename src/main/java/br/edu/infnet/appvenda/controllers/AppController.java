package br.edu.infnet.appvenda.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.edu.infnet.appvenda.models.services.CleaningService;
import br.edu.infnet.appvenda.models.services.PharmaceuticalService;
import br.edu.infnet.appvenda.models.services.ProductService;
import br.edu.infnet.appvenda.models.services.InformationService;
import br.edu.infnet.appvenda.models.services.SellerService;

@Controller
public class AppController {

    @Autowired
    private SellerService sellerService;
    @Autowired
    private ProductService productService;
    @Autowired
    private CleaningService cleaningService;
    @Autowired
    private PharmaceuticalService pharmaceuticalService;
    @Autowired
    private InformationService informationService;

    @GetMapping(value = "/")
    public String showHome(Model model) {

        model.addAttribute("informations", informationService.findAll());
        model.addAttribute("sellerQuantity", sellerService.findCount());
        model.addAttribute("productQuantity", productService.findCount());
        model.addAttribute("cleaningQuantity", cleaningService.findCount());
        model.addAttribute("pharmaceuticalQuantity", pharmaceuticalService.findCount());

        return "home";

    }

}
