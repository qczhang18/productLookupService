package com.digitalcrafts.syntel.services;

import com.digitalcrafts.syntel.dao.ProductLookupDao;
import com.digitalcrafts.syntel.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductLookupService {

    @Qualifier("postgresProductLookupDao")
    @Autowired
    ProductLookupDao productLookupDao;

    public Product productLookupServiceById(long queryId){
       return productLookupDao.lookupById(queryId);
    }

    public void addProduct(Product product) {
        productLookupDao.addProduct(product);
    }

    public List<Product> productLookupListAll() {
        return productLookupDao.getProductListAll();
    }
}
