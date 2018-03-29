package com.digitalcrafts.syntel.dao;

import com.digitalcrafts.syntel.model.Product;

public interface ProductLookupDao {

    public Product lookupById(long id);
}
