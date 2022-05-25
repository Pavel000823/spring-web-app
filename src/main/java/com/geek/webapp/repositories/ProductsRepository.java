package com.geek.webapp.repositories;

import com.geek.webapp.model.Product;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Repository
public class ProductsRepository {

    private List<Product> products;

    @PostConstruct
    private void init() {
        products = new ArrayList<>();
        products.addAll(Arrays.asList(new Product("1", "Молоко", 100),
                new Product("2", "Сыр", 250),
                new Product("3", "Кофе", 1000)));
    }

    public List<Product> getAll() {
        return Collections.unmodifiableList(products);
    }

    public Product getProductById(String id) {
        return products.stream().filter(p -> p.getId().equals(id)).findFirst().get();
    }

    public void save(Product product) {
        products.add(product);
    }
}
