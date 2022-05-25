package com.geek.webapp.model;

public class Product {

    private final String id;
    private final String title;
    private final double cost;

    public Product(String id, String title, double cost) {
        this.id = id;
        this.title = title;
        this.cost = cost;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public double getCost() {
        return cost;
    }
}
