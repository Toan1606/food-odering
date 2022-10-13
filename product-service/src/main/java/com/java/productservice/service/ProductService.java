package com.java.productservice.service;

import com.java.productservice.dto.ProductDTO;
import com.java.productservice.entity.Product;
import com.java.productservice.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ProductService {

    private final ProductRepository productRepository;

    public List<Product> findAllProduct() {
        return productRepository.findAll();
    }

    public Product addProduct(ProductDTO productDTO) {
        Product product = Product.builder().productName(productDTO.getProductName()).price(productDTO.getPrice()).description(productDTO.getDescription()).build();
        Product savedProduct = productRepository.save(product);
        return savedProduct;
    }
}
