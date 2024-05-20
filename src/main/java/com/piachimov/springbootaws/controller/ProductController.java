package com.piachimov.springbootaws.controller;

import com.piachimov.springbootaws.dto.ProductRequestDto;
import com.piachimov.springbootaws.dto.ProductResponseDto;
import com.piachimov.springbootaws.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;


    @PostMapping
    public Mono<ProductResponseDto> createProduct(@RequestBody ProductRequestDto productRequestDto) {
        return productService.createProduct(productRequestDto);
    }

    @GetMapping
    public Flux<ProductResponseDto> getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Mono<ProductResponseDto> getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }
}
