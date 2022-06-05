package com.geek.webapp.dao;

import com.geek.webapp.MyAppBdSessionFactory;
import com.geek.webapp.model.Product;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductDao {

    private final MyAppBdSessionFactory factory;

    @Autowired
    public ProductDao(MyAppBdSessionFactory myAppBdSessionFactory) {
        factory = myAppBdSessionFactory;
    }

    public List<Product> findAll() {
        try (Session session = factory.getSession()) {
            session.beginTransaction();
            List<Product> products = session.createQuery("from Product ", Product.class).getResultList();
            System.out.println(products);
            session.getTransaction().commit();
            return products;
        }
    }

    public Product findById(Long id) {
        try (Session session = factory.getSession()) {
            session.beginTransaction();
            Product product = session.get(Product.class, id);
            session.getTransaction().commit();
            return product;
        }
    }

    public void saveOrUpdate(Product product) {
        try (Session session = factory.getSession()) {
            session.beginTransaction();
            Product entity = session.get(Product.class, product.getId());
            entity.setCost(product.getCost());
            session.save(entity);
            session.getTransaction().commit();
        }
    }


}
