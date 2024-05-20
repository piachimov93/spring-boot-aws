package com.piachimov.springbootaws.repository;

import com.piachimov.springbootaws.dao.ProductEntity;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

public interface ProductRepository extends R2dbcRepository<ProductEntity, Long> {

}
