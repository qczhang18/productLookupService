package com.digitalcrafts.syntel.controller;

import com.digitalcrafts.syntel.model.Product;
import com.digitalcrafts.syntel.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/product")
    public Product productLookup(@RequestParam(value = "id", required = true) long queryID) {
        return productService.getProductById(queryID);
    }

    @PostMapping("/product")
    public void addProduct(@RequestBody Product product) {
        productService.addProduct(product);
    }

    @RequestMapping("/products")
    public List<Product> productListLookup() {
        return productService.getProductListAll();
    }

}