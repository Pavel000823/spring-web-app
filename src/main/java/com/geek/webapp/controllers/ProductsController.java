package com.geek.webapp.controllers;

import com.geek.webapp.model.Product;
import com.geek.webapp.services.ProductsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ProductsController {

    ProductsService productsService;

    ProductsController(ProductsService productsService) {
        this.productsService = productsService;
    }

    @GetMapping(value = "/show_all_products")
    public String showProductsPage(Model model){
        model.addAttribute("products", productsService.getAll());
        return "products_info";
    }

    @GetMapping(value = "/create")
    public String addProduct(){
        return "create_product";
    }


    @PostMapping(value = "/create")
    public String saveProduct(@RequestParam String id, @RequestParam String title, @RequestParam double cost){
        productsService.save(new Product(id, title, cost));
        return "redirect:/show_all_products";
    }
}
