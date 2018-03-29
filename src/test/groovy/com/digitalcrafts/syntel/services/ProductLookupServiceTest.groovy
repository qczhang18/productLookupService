package com.digitalcrafts.syntel.services

import com.digitalcrafts.syntel.dao.ArrayProductLookupDao
import com.digitalcrafts.syntel.dao.ProductLookupDao
import com.digitalcrafts.syntel.model.Product
import spock.lang.Specification

class ProductLookupServiceTest extends Specification {

   def "Product service lookup by valid ID"(){

       given: "a valid product ID"
       Product sampleProduct = new Product(111,"testProduct", 234);

       and: "a productDao that always return this product"
       ProductLookupDao arrayProductLookupDao = Stub(ArrayProductLookupDao.class)
       arrayProductLookupDao.lookupById(111) >> sampleProduct

       and: "a product lookup service which is the class under test"
       ProductLookupService productLookupService = new ProductLookupService();
       productLookupService.setProductLookupDao(arrayProductLookupDao);

       when: "we ask for the price of the product"
       Double price  = productLookupService.productLookupServiceById(111).getPrice();

       then: "we retrieve product price"
       price == 234;
   }

}
