package edu.icet.demo.repository;

import edu.icet.demo.entity.ProductEntity;
import org.springframework.data.repository.CrudRepository;

public interface ProductJpaRepository extends CrudRepository<ProductEntity,Integer> {
}
