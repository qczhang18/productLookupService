package com.digitalcrafts.syntel.dao;

import com.digitalcrafts.syntel.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Component
public class ProductDaoPostgres extends JdbcDaoSupport implements ProductDao {

    @Qualifier("dataSource")
    @Autowired
    private DataSource dataSource;

    @PostConstruct
    private void initialize() {
        setDataSource(dataSource);
    }

    @Override
    public Product getProductById(long id) {

        Product product = null;
        String sql = "SELECT * FROM Product WHERE ID=" + id;

        List<Map<String, Object>> list = getJdbcTemplate().queryForList(sql);
        for (Map<String, Object> row : list) {
            product = new Product();
            product.setId((Long) row.get("id"));
            product.setName((String) row.get("name"));
            product.setPrice(Long.valueOf((Long) row.get("price")));
        }

        return product;
    }

    @Override
    public void addProduct(Product product) {

        String sql = "INSERT INTO Product VALUES(?,?,?)";

        getJdbcTemplate().update(sql, new Object[]{product.getId(),
                product.getName(), product.getPrice()});
    }


    @Override
    public List<Product> getProductListAll() {

        List<Product> productList = new ArrayList<>();

        String sql = "SELECT * FROM Product";

        List<Map<String, Object>> list = getJdbcTemplate().queryForList(sql);
        for (Map<String, Object> row : list) {
            Product product = new Product();
            product.setId((Long) row.get("id"));
            product.setName((String) row.get("name"));
            product.setPrice(Long.valueOf((Long) row.get("price")));
            productList.add(product);
        }

        return productList;
    }
}
