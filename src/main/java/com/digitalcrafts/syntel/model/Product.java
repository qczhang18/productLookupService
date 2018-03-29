package com.digitalcrafts.syntel.model;

public class Product {

    private long id;
    private String content;
    private double price;

    public Product(long id, String name, double price) {
        this.id = id;
        this.content = name;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public double getPrice(){
       return price;
    }
}