package com.piachimov.springbootaws.service;

import com.piachimov.springbootaws.dao.ProductEntity;
import com.piachimov.springbootaws.dto.ProductRequestDto;
import com.piachimov.springbootaws.dto.ProductResponseDto;
import com.piachimov.springbootaws.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public Mono<ProductResponseDto> createProduct(ProductRequestDto productRequestDto) {
        ProductEntity productEntity = new ProductEntity();
        productEntity.setName(productRequestDto.name());

        return productRepository.save(productEntity)
            .map(savedProductEntity -> new ProductResponseDto(savedProductEntity.getId(), savedProductEntity.getName()));
    }

    public Flux<ProductResponseDto> getAllProducts() {
        return productRepository.findAll()
            .map(productEntity -> new ProductResponseDto(productEntity.getId(), productEntity.getName()));
    }

    public Mono<ProductResponseDto> getProductById(Long id) {
        return productRepository.findById(id)
            .map(productEntity -> new ProductResponseDto(productEntity.getId(), productEntity.getName()));
    }
}
