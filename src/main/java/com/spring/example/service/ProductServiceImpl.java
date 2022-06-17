package com.spring.example.service;

import com.spring.example.config.ResourceNotFoundException;
import com.spring.example.dto.product.RequestProduct;
import com.spring.example.model.ProductEntity;
import com.spring.example.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;


    @Override
    public ProductEntity createProductEntity(RequestProduct requestProduct) {
        ProductEntity productEntity = new ProductEntity();
        return bindingDataSaveAndUpdateProduct(requestProduct, productEntity);
    }

    @Override
    public ProductEntity updateProductEntity(RequestProduct requestProduct, Long id) {
        ProductEntity productDb = this.productRepository.findProductEntitiesById(id);

        if (Objects.nonNull(productDb)){
            return bindingDataSaveAndUpdateProduct(requestProduct, productDb);
        }else {
            throw new ResourceNotFoundException("Record not found with id : " + id);
        }
    }

    private ProductEntity bindingDataSaveAndUpdateProduct(RequestProduct requestProduct , ProductEntity productEntity){
        productEntity.setName(requestProduct.getName());
        productEntity.setDescription(requestProduct.getDescription());
        productEntity.setPrice(requestProduct.getPrice());
        return productRepository.save(productEntity);
    }

    @Override
    public List<ProductEntity> getAllProductEntity() {
        return productRepository.findAll();
    }

    @Override
    public ProductEntity getProductEntityById(long id){
        Optional < ProductEntity > productDb = this.productRepository.findById(id);

        if (productDb.isPresent()) {
            return productDb.get();
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + id);
        }
    }

    @Override
    public void deleteProductEntity(long id) {
        Optional <ProductEntity> productDb = this.productRepository.findById(id);

        if (productDb.isPresent()){
            this.productRepository.delete(productDb.get());
        }else {
            throw new ResourceNotFoundException("Record not found with id : " + id);
        }
    }
}
