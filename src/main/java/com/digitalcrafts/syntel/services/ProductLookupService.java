package com.digitalcrafts.syntel.services;

import com.digitalcrafts.syntel.dao.ProductLookupDao;
import com.digitalcrafts.syntel.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class ProductLookupService {

    @Qualifier("arrayProductLookupDao")
    @Autowired
    ProductLookupDao productLookupDao;

    public Product productLookupServiceById(long queryId){
       return productLookupDao.lookupById(queryId);
    }

    public void setProductLookupDao(ProductLookupDao productLookupDao){
        this.productLookupDao = productLookupDao;
    }
}
