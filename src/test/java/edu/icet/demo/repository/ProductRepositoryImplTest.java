package edu.icet.demo.repository;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class ProductRepositoryImplTest {

    @Autowired
    ProductNativeRepository productNativeRepository;

    @Test
    void retrieveProductCount(){
        Long count = productNativeRepository.retrieveProductCount();
        Assertions.assertTrue(count>-1);
        log.info(String.valueOf(count));
    }
}
