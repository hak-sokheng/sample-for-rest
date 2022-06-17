package com.spring.example.service;

import com.spring.example.dto.product.RequestProduct;
import com.spring.example.model.ProductEntity;

import java.util.List;

public interface ProductService {
    ProductEntity createProductEntity(RequestProduct requestProduct);

    ProductEntity updateProductEntity(RequestProduct requestProduct, Long id);

    List<ProductEntity> getAllProductEntity();

    ProductEntity getProductEntityById(long query);

    void deleteProductEntity(long id);
}
