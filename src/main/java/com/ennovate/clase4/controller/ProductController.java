package com.ennovate.clase4.controller;

import com.ennovate.clase4.model.Product;
import com.ennovate.clase4.model.ProductDtoRequest;
import com.ennovate.clase4.service.IProduct;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/product")
public class ProductController {

    private final IProduct productService;

    @GetMapping
    public List<Product> getProducts(){
        return productService.getProducts();
    }

    @PostMapping
    public Product create(@RequestBody ProductDtoRequest request){
        return productService.create(request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        productService.delete(id);
    }

}
