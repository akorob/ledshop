package com.spring.persistence.dao;

import com.spring.persistence.domain.Product;

import java.util.List;

/**
 * Created by Andrey on 29.12.2014.
 */
public interface ProductDao {
    void persist(Product pr);

    List<Product> getAll();
}
