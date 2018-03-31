package com.digitalcrafts.syntel.dao;

import com.digitalcrafts.syntel.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Component
public class PostgresProductLookupDao implements ProductLookupDao {

    @Qualifier("dataSource")
    @Autowired
    private DataSource dataSource;

    private JdbcTemplate jdbcTemplate;

    @PostConstruct
    public void initDataSource() {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Product lookupById(long id) {

        Product product = null;
        String sql = "SELECT * FROM Product WHERE ID=" + id;

        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
        for (Map<String, Object> row : list) {
            product = new Product();
            product.setId((Long) row.get("id"));
            product.setName((String) row.get("name"));
            product.setPrice(Long.valueOf((Long)row.get("price")));
        }

        return product;
    }

    @Override
    public void addProduct(Product product) {

        String sql = "INSERT INTO Product VALUES(?,?,?)";

        jdbcTemplate.update(sql, new Object[]{product.getId(),
                product.getName(), product.getPrice()});
    }


    @Override
    public List<Product> getProductListAll() {

        List<Product> productList = new ArrayList<>();

        String sql = "SELECT * FROM Product";

        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
        for (Map<String, Object> row : list) {
            Product product = new Product();
            product.setId((Long) row.get("id"));
            product.setName((String) row.get("name"));
            product.setPrice(Long.valueOf((Long)row.get("price")));
            productList.add(product);
        }

        return productList;
    }
}
