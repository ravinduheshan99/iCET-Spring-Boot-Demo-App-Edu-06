package edu.icet.demo.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.icet.demo.entity.ProductEntity;
import edu.icet.demo.model.Product;
import edu.icet.demo.repository.ProductJpaRepository;
import edu.icet.demo.repository.ProductNativeRepository;
import edu.icet.demo.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductNativeRepository repositoryNative;
    private final ProductJpaRepository repositoryJpa;
    private final ObjectMapper mapper;

    @Override
    public Long retrieveProductCount() {
        return repositoryNative.retrieveProductCount();
    }

    @Override
    public Product persist(Product product) {
        ProductEntity savedEntity = repositoryJpa.save(mapper.convertValue(product, ProductEntity.class));
        return mapper.convertValue(savedEntity,Product.class);
    }
}
