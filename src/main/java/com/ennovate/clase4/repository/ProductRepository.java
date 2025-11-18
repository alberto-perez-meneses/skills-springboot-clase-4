package com.ennovate.clase4.repository;

import com.ennovate.clase4.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
