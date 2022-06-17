package com.spring.example.controller;

import com.spring.example.config.ResourceNotFoundException;
import com.spring.example.dto.product.RequestProduct;
import com.spring.example.model.ProductEntity;
import com.spring.example.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/products")
    public ResponseEntity < ProductEntity > createProduct(@RequestBody RequestProduct product) {
        return ResponseEntity.ok().body(this.productService.createProductEntity(product));
    }

    @GetMapping("/products")
    public ResponseEntity <List< ProductEntity >> getAllProduct() {
        return ResponseEntity.ok().body(productService.getAllProductEntity());
    }

    @PutMapping("/products/{id}")
    public ResponseEntity < ProductEntity > updateProduct(@PathVariable long id, @RequestBody RequestProduct requestProduct) {
        return ResponseEntity.ok().body(this.productService.updateProductEntity(requestProduct, id));
    }

    @GetMapping("/products/{id}")
    public ResponseEntity < ProductEntity > getProductEntityById(@PathVariable long id) {
        return ResponseEntity.ok().body(productService.getProductEntityById(id));
    }

    @DeleteMapping("/products/{id}")
    public HttpStatus deleteProductEntity(@PathVariable long id){
        this.productService.deleteProductEntity(id);
        return HttpStatus.OK;
    }
}
