package com.digitalcrafts.syntel.services;

import com.digitalcrafts.syntel.model.Product;
import com.digitalcrafts.syntel.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {

//    @Qualifier("postgresProductLookupDao")
//    @Autowired
//    ProductDao productLookupDao;
//
//    public Product productLookupServiceById(long queryId) {
//        return productLookupDao.lookupById(queryId);
//    }
//
//    public void addProduct(Product product) {
//        productLookupDao.addProduct(product);
//    }
//
//    public List<Product> productLookupListAll() {
//        return productLookupDao.getProductListAll();
//    }
//


    @Autowired
    private ProductRepository productRepository;

    public Optional<Product> getProduct(long queryID) {
        return productRepository.findById(queryID);
    }

    public Iterable<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public String addNewProduct(Product product) {
        productRepository.save(product);
        return "Saved";
    }
}
