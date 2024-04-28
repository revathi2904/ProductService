package com.scaler.productservice.repositories;

import com.scaler.productservice.models.Product;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRespository
    extends JpaRepository<Product, Long> {

    // Product findById(Long id);
    // this will return null if no product matches. so add optional.
    Optional<Product> findById(Long id);

    List<Product> findBy();
    Product save(Product product);



}
 