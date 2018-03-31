package com.digitalcrafts.syntel.controller;

import com.digitalcrafts.syntel.services.ProductLookupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.digitalcrafts.syntel.model.Product;

import java.util.List;


@RestController
public class ProductLookupController {

    @Autowired
    ProductLookupService productLookupService;

    @RequestMapping("/product")
    public Product productLookup(@RequestParam(value="id", required =true ) long queryID) {
        return productLookupService.productLookupServiceById(queryID);
    }

    @RequestMapping("/products")
    public List<Product> productListLookup(){
        return productLookupService.productLookupListAll();
    }

    @RequestMapping(value = "/addproduct", method = RequestMethod.POST)
    public void addProduct(@RequestBody Product product){
        productLookupService.addProduct(product);
    }
}