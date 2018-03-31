package com.digitalcrafts.syntel.services

import com.digitalcrafts.syntel.dao.ArrayProductLookupDao
import com.digitalcrafts.syntel.dao.ProductLookupDao
import com.digitalcrafts.syntel.model.Product
import spock.lang.Specification

class ProductLookupServiceTest extends Specification {

    def "Product service lookup by valid product ID"() {

        given: "a valid product"
        Product sampleProduct = new Product(111, "testProduct", 234);

        and: "a productDao that always return this product"
        ProductLookupDao arrayProductLookupDao = Stub(ArrayProductLookupDao.class)
        arrayProductLookupDao.lookupById(111) >> sampleProduct

        and: "a product lookup service which is the class under test"
        ProductLookupService productLookupService = new ProductLookupService();
        productLookupService.productLookupDao = arrayProductLookupDao;

        when: "we ask for the price of the product"
        Double price = productLookupService.productLookupServiceById(111).getPrice();

        then: "we retrieve product price"
        price == 234;
    }


    def "Add a valid product through service"(){

        given:  "a empty arrayList of product"
        List<Product> productList = new ArrayList<>();

        and:    "a datasource/DAO house the arrayList of product"
        ProductLookupDao arrayProductLookupDao = new ArrayProductLookupDao();
        arrayProductLookupDao.productList = productList;

        and:    "a product service"
        ProductLookupService productLookupService = new ProductLookupService()
        productLookupService.productLookupDao = arrayProductLookupDao;

        when:   "add a new product through service"
        productLookupService.addProduct(new Product(111, "Valid Product", 999))

        then:   "datasource/DAO increase its size"
        productList.size() == 1;
    }
}

