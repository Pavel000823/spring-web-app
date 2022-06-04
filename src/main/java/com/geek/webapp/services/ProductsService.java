package com.geek.webapp.services;

import com.geek.webapp.dao.ProductDao;
import com.geek.webapp.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductsService {

    private final ProductDao productsRepository;

    @Autowired
    public ProductsService(ProductDao productsRepository) {
        this.productsRepository = productsRepository;
    }

    public List<Product> findAll() {
        return productsRepository.findAll();
    }

    public Product getProductById(Long id) {
        return productsRepository.findById(id);
    }

    public void updateCost(Long id, String operation) {
        Product product = getProductById(id);
        if (operation.equals("minus")) {
            product.setCost(product.getCost() - 1);
            save(product);
            return;
        }
        if (operation.equals("plus")) {
            product.setCost(product.getCost() + 1);
            save(product);
        }
    }

    public void save(Product product) {
        productsRepository.saveOrUpdate(product);
    }
}
