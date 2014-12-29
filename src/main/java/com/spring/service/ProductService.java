package com.spring.service;

import com.spring.model.ProductDto;
import com.spring.persistence.domain.Product;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Andrey on 29.12.2014.
 */
public interface ProductService {
    @Transactional
    void save(Product guest);

    List<ProductDto> findAll();
}
