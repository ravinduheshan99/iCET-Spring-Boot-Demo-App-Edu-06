package edu.icet.demo.repository.impl;

import edu.icet.demo.repository.ProductNativeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepositoryImpl implements ProductNativeRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Long retrieveProductCount(){
        //jdbcTemplate.queryForList() <------------if we expecting a results set
        Long count = jdbcTemplate.queryForObject("SELECT count(*) FROM product", Long.class);
        return count;
    }
}
