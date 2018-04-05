//package com.digitalcrafts.syntel.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.stereotype.Component;
//
//import javax.sql.DataSource;
//
//
//@Component
//public class CommonConfig {
//
//    @Qualifier("dataSource")
//    @Autowired
//    private DataSource dataSource;
//
//    public JdbcTemplate getJdbcTemplate(DataSource dataSource){
//        return new JdbcTemplate(dataSource);
//    }
//}
