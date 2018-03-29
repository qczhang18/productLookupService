package com.digitalcrafts.syntel.model;

public class Product {

    private long id;
    private String name;
    private double price;

    public Product(long id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return name;
    }

    public double getPrice(){
       return price;
    }
}