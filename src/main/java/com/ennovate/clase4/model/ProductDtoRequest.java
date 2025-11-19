package com.ennovate.clase4.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ProductDtoRequest {
    @NotBlank
    private Long id;
    @NotBlank
    private String nombre;
    @NotBlank
    @Size(min = 3, max = 15, message = "El segundo sku debe tener entre 1 y 10 caracteres.")
    private String sku;
    @NotBlank
    @Size(min = 3, max = 15, message = "El segundo precio debe tener entre 1 a 4 caracteres.")
    private Double precio;
}
