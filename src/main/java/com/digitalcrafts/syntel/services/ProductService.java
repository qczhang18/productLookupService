package com.digitalcrafts.syntel.services;

import com.digitalcrafts.syntel.dao.ProductDao;
import com.digitalcrafts.syntel.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Qualifier("productDaoPostgres")
    @Autowired
    ProductDao productDao;

    public Product getProductById(long queryId) {
        return productDao.getProductById(queryId);
    }

    public void addProduct(Product product) {
        productDao.addProduct(product);
    }

    public List<Product> getProductListAll() {
        return productDao.getProductListAll();
    }
}
