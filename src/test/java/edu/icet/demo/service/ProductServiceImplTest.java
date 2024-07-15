package edu.icet.demo.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class ProductServiceImplTest {

    @Autowired
    ProductService productServiceImpl;

    @Test
    void retrieveProductCountTest() {
        Long count = productServiceImpl.retrieveProductCount();
        log.info(String.valueOf(count));
    }
}

