package com.digitalcrafts.syntel.controller;

import com.digitalcrafts.syntel.dao.ArrayProductLookupDao;
import com.digitalcrafts.syntel.dao.ProductLookupDao;
import com.digitalcrafts.syntel.services.ProductLookupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.digitalcrafts.syntel.model.Product;


@RestController
public class ProductLookupController {

    @Autowired
    ProductLookupService productLookupService;

    @RequestMapping("/productlookup")
    public Product productLookup(@RequestParam(value="id", required =true ) long queryID) {
        return productLookupService.productLookupServiceById(queryID);
    }
}