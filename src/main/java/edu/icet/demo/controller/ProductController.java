package edu.icet.demo.controller;

import edu.icet.demo.model.Product;
import edu.icet.demo.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productServiceImpl;
    // var ProductService = new ProductServiceImpl();<--------------Java Type in-referencing (after java 17)
    //reference type is not mention. instead of that they use var keyword here.

    @GetMapping("/product-count")
    public Map<String, Long> retrieveProductCount(){
        return Collections.singletonMap("productCount",productServiceImpl.retrieveProductCount());
    }

    @PostMapping()
    public Product persist(@RequestBody Product product){
        return productServiceImpl.persist(product);
    }
}
