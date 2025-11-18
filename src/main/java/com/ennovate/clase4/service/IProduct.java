package com.ennovate.clase4.service;

import com.ennovate.clase4.model.Product;
import com.ennovate.clase4.model.ProductDtoRequest;

import java.util.List;

public interface IProduct {

    List<Product> getProducts();
    Product create(ProductDtoRequest product);
}
