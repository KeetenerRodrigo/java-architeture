package br.edu.infnet.appvenda.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.edu.infnet.appvenda.models.domains.Product;
import br.edu.infnet.appvenda.models.services.ProductService;

@Controller
public class ProductController {

    @Autowired
    private AppController appController;

    @Autowired
    private ProductService productService;

    @GetMapping(value = "/product/search")
    public String search(Model model, String searchField){

        List<Product> products = productService.findByName(searchField);

        if(products != null && !products.isEmpty()) {

            model.addAttribute("list", products);
            model.addAttribute("title", null);

            return appController.showHome(model);

        } 

        return "redirect:/product/list";

    }

    @GetMapping(value = "/product/{id}/delete")
    public String delete(@PathVariable Integer id) {

        productService.delete(id);

        return "redirect:/product/list";

    }

    @GetMapping(value = "/product/list")
    public String getPharmaceuticals(Model model) {

        model.addAttribute("route", "product");
        model.addAttribute("title", "Produtos");
        model.addAttribute("list", productService.findAll());

        return appController.showHome(model);

    }

}
