package com.ennovate.clase4.service.impl;

import com.ennovate.clase4.model.Product;
import com.ennovate.clase4.model.ProductDtoRequest;
import com.ennovate.clase4.repository.ProductRepository;
import com.ennovate.clase4.service.IProduct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ProductImpl implements IProduct {

    @Autowired
    private final ProductRepository productRepository;

    public ProductImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product create(ProductDtoRequest product) {
        log.debug("create product with id: {}",product.getSku());

        Product productEntity= new Product();
        productEntity.setSku(product.getSku());
        productEntity.setNombre(product.getNombre());
        productEntity.setPrecio(product.getPrecio());

        return productRepository.save(productEntity);
    }

    @Override
    public Product update(ProductDtoRequest product) {
        Product prodEntity = new Product();
        prodEntity.setId(product.getId());
        prodEntity.setNombre(product.getNombre());
        prodEntity.setSku(product.getSku());
        prodEntity.setPrecio(product.getPrecio());
        return productRepository.save(prodEntity);
    }

}
