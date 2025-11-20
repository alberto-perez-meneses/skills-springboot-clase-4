package com.ennovate.clase4.service.impl;

import com.ennovate.clase4.config.AppConfigProperties;
import com.ennovate.clase4.model.Product;
import com.ennovate.clase4.model.ProductDtoRequest;
import com.ennovate.clase4.repository.ProductRepository;
import com.ennovate.clase4.service.IProduct;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@Profile({"mxdev"})
@AllArgsConstructor
public class MxProductImpl implements IProduct {

    private final ProductRepository productRepository;
    private final AppConfigProperties appConfigProperties;




    @Override
    public List<Product> getProducts() {
        log.info("el pais es : {} y el client id es {}", appConfigProperties.getCountry(),
                appConfigProperties.getClientId());
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
    public void delete(Long id) {
        productRepository.deleteById(id);
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

    @Override
    public List<Product> buscarPorPrecioMayorA(Double precio) {
        return productRepository.buscarPorPrecioMayorA(precio);
    }
}
