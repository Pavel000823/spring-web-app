package com.geek.webapp.services;

import com.geek.webapp.model.Product;
import com.geek.webapp.repositories.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductsService {

    private final ProductsRepository productsRepository;

    @Autowired
    public ProductsService(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }

    public List<Product> getAll() {
        return productsRepository.getAll();
    }

    public Product getProductById(String id) {
        return productsRepository.getProductById(id);
    }

    public void save(Product product) {
        productsRepository.save(product);
    }
}
