package com.ennovate.clase4.repository;

import com.ennovate.clase4.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("SELECT p FROM product p WHERE p.precio > :precio")
    List<Product> buscarPorPrecioMayorA(@Param("precio") Double precio);
    // todo: implementar buscar por sku
    List<Product> findBySku(String sku);
    // Consulta nativa
    @Query(value = "SELECT * FROM product WHERE PRECIO < :precio", nativeQuery = true)
    List<Product> buscarPorPrecioMenorA(@Param("precio") double precio);
}
