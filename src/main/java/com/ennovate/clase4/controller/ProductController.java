package com.ennovate.clase4.controller;

import com.ennovate.clase4.model.Product;
import com.ennovate.clase4.model.ProductDtoRequest;
import com.ennovate.clase4.service.IProduct;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/product")
public class ProductController {

    private final IProduct productService;

    @GetMapping
    public ResponseEntity<List<Product>> getProducts(){
        List<Product> products = productService.getProducts();
        return ResponseEntity.ok(products);
    }

    @GetMapping("/find-by/precio")
    public List<Product> buscarPorPrecioMayorA(@RequestParam Double precio){
        return productService.buscarPorPrecioMayorA(precio);
    }

    @PostMapping
    public ResponseEntity <Product> create(@RequestBody ProductDtoRequest request){
        Product product = productService.create(request);
        return ResponseEntity.ok(product);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        productService.delete(id);
    }
    @PutMapping
    public Product update(@RequestBody ProductDtoRequest request){
        return productService.update(request);
    }

}
