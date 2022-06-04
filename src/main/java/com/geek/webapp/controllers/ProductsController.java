package com.geek.webapp.controllers;

import com.geek.webapp.model.Product;
import com.geek.webapp.services.ProductsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductsController {

    private final ProductsService productsService;

    ProductsController(ProductsService productsService) {
        this.productsService = productsService;
    }

    @GetMapping(value = "/show_all_products")
    public String showProductsPage(Model model) {
        model.addAttribute("products", productsService.findAll());
        return "products_info";
    }

    @GetMapping(value = "/create")
    public String addProduct() {
        return "create_product";
    }


    @PostMapping(value = "/create")
    public String saveProduct(@RequestParam String title, @RequestParam double cost) {
        productsService.save(new Product(title, cost));
        return "redirect:/products/show_all_products";
    }

    @GetMapping(value = "/updateCost")
    public String updateCost(@RequestParam long id, @RequestParam String operation) {
        productsService.updateCost(id, operation);
        return "redirect:/products/show_all_products";
    }
}
