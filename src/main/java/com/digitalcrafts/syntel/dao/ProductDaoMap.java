package com.digitalcrafts.syntel.dao;

import com.digitalcrafts.syntel.model.Product;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class ProductDaoMap implements ProductDao {

    Map<Product, Integer> productIntegerMap;

    @PostConstruct
    public void init() {
        productIntegerMap = new HashMap<>();
        productIntegerMap.put(new Product(111, "111Map", 111), 111);
        productIntegerMap.put(new Product(222, "222Map", 222), 222);
        productIntegerMap.put(new Product(333, "333Map", 333), 333);
    }

    public Product getProductById(long id) {
        Product queryProduct = null;
        for (Product product : productIntegerMap.keySet()) {
            if (product.getId() == id) {
                queryProduct = product;
            }
        }
        return queryProduct;
    }

    public void addProduct(Product product) {
        productIntegerMap.put(product, 1);
    }

    @Override
    public List<Product> getProductListAll() {
        return null;
    }
}
