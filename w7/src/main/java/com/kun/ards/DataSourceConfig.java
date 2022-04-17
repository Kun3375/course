//package com.kun.ards;
//
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.boot.jdbc.DataSourceBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.jdbc.core.JdbcTemplate;
//
//import javax.sql.DataSource;
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * @author kun
// * @date 2022/4/17
// */
//@Configuration
//public class DataSourceConfig {
//
//    @Bean
//    public JdbcTemplate jdbcTemplate(DataSource routingDataSource) {
//        return new JdbcTemplate(routingDataSource);
//    }
//
//    @Bean
//    public DataSource routingDataSource() {
//        CustomDataSource customDataSource = new CustomDataSource();
//        Map<Object, Object> targetDataSources = new HashMap<>(4);
//        targetDataSources.put("main", mainDataSource());
//        targetDataSources.put("slave", slaveDataSource());
//        customDataSource.setTargetDataSources(targetDataSources);
//        return customDataSource;
//    }
//
//    @Bean
//    @ConfigurationProperties("datasource.main")
//    public DataSource mainDataSource() {
//        return DataSourceBuilder.create().build();
//    }
//
//    @Bean
//    @ConfigurationProperties("datasource.slave")
//    public DataSource slaveDataSource() {
//        return DataSourceBuilder.create().build();
//    }
//}
