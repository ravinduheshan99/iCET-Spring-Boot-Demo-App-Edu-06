package edu.icet.demo.service;

import edu.icet.demo.model.Product;

public interface ProductService {
    public Long retrieveProductCount();
    public Product persist(Product product);
}
