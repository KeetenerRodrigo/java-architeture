package br.edu.infnet.appvenda.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.edu.infnet.appvenda.models.services.CleaningService;
import br.edu.infnet.appvenda.models.services.PharmaceuticalService;
import br.edu.infnet.appvenda.models.services.ProductService;
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

    @GetMapping(value = "/")
    public String showHome(Model model) {

        model.addAttribute("sellerQuantity", sellerService.findCount());
        model.addAttribute("productQuantity", productService.findCount());
        model.addAttribute("cleaningQuantity", cleaningService.findCount());
        model.addAttribute("pharmaceuticalQuantity", pharmaceuticalService.findCount());

        return "home";

    }

    @GetMapping(value = "/products")
    public String getProducts(Model model) {

        model.addAttribute("title", "Produtos:");
        model.addAttribute("products", productService.findAll());

        return showHome(model);
        
    }

    @GetMapping(value = "/cleanings")
    public String getCleaningProducts(Model model) {

        model.addAttribute("title", "Produtos de Limpeza:");
        model.addAttribute("cleanings", cleaningService.findAll());

        return showHome(model);

    }

    @GetMapping(value = "/pharmaceuticals")
    public String getPharmaceuticalProducts(Model model) {

        model.addAttribute("title", "Produtos Farmacêutico:");
        model.addAttribute("pharmaceuticals", pharmaceuticalService.findAll());

        return showHome(model);

    }

}
