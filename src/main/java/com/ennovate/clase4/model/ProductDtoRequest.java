package com.ennovate.clase4.model;

import lombok.Data;

@Data
public class ProductDtoRequest {
    private Long id;
    private String nombre;
    private String sku;
    private Double precio;
}
