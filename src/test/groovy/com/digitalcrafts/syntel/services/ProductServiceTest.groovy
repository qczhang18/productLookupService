package com.digitalcrafts.syntel.services

import com.digitalcrafts.syntel.dao.ProductDaoArray
import com.digitalcrafts.syntel.dao.ProductDaoPostgres
import com.digitalcrafts.syntel.dao.ProductDao
import com.digitalcrafts.syntel.model.Product
import spock.lang.Specification

class ProductServiceTest extends Specification {

    def "Get Product with valid product ID"() {

        given: "a valid product"
        Product sampleProduct = new Product(111, "testProduct", 234);

        and: "a productDao that always return this product"
        ProductDao arrayProductDao = Stub(ProductDaoArray.class)
        arrayProductDao.getProductById(111) >> sampleProduct

        and: "a Product Service which is the class under test"
        ProductService productService = new ProductService();
        productService.productDao = arrayProductDao;

        when: "we ask for the price of the product"
        Double price = productService.getProductById(111).getPrice();

        then: "we retrieve product price"
        price == 234;
    }


    def "Add a valid product through service"(){

        given:  "a valid sample product"
        Product sampleProduct = new Product(111,"valid product", 999)

        and:    "a product service"
        ProductService productService = Mock(ProductService.class)

        when:   "add a new product through service"
        productService.addProduct(sampleProduct)

        then:   "datasource/DAO increase its size"
        1 * productService.addProduct(sampleProduct)

    }


//    def "Add an invalid product through service"(){
//
//        given:  "a valid sample product"
//        Product sampleProduct = null;
//
//        and:    "a product service"
//        ProductService productService = Mock(ProductService.class)
//
//        when:   "add a new product through service"
//        productService.addProduct(sampleProduct)
//
//        then:   "datasource/DAO increase its size"
//        1 * productService.addProduct(sampleProduct)
//
//    }
}

