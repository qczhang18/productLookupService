package com.digitalcrafts.syntel.dao;

import com.digitalcrafts.syntel.model.Product;

import java.util.List;

public interface ProductDao {

    public Product lookupById(long id);

    public void addProduct(Product product);

    public List<Product> getProductListAll();
}
