package com.fawry.demo.repository;

import com.fawry.demo.entity.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
    List<Product> findAllByBuyingCounter(long buyingCounter);
}
