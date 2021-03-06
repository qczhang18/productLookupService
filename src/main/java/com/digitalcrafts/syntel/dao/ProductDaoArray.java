package com.digitalcrafts.syntel.dao;

import com.digitalcrafts.syntel.model.Product;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class ProductDaoArray implements ProductDao {

    private List<Product> productList;


    //    public ProductDao(){
    @PostConstruct
    public void init() {
        productList = new ArrayList<>();
        productList.add(new Product(111, "111coke", 3.5));
        productList.add(new Product(222, "222pepsi", 3.5));
        productList.add(new Product(333, "333water", 2.5));
    }

    public Product getProductById(long id) {
        Product queryProduct = null;
        for (Product product : productList) {
            if (product.getId() == id) {
                queryProduct = product;
            }
        }
        return queryProduct;
    }

    public void addProduct(Product product) {
        productList.add(product);
    }

    public List<Product> getProductListAll() {
        return productList;
    }
}
