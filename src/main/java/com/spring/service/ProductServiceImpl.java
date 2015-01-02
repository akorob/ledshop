package com.spring.service;

import com.spring.model.ProductDto;
import com.spring.persistence.dao.ProductDao;
import com.spring.persistence.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andrey on 29.12.2014.
 */
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDao productDao;

    @Override
    @Transactional
    public void save(Product guest) {
        productDao.persist(guest);
    }


    @Override
    public List<ProductDto> getAll() {
        List <ProductDto> list = new ArrayList<>();
        for (Product p:productDao.getAll()){
            list.add(new ProductDto(p));
        }
        return list;
    }

    @Override
    public List<ProductDto> getEnable() {
        List <ProductDto> list = new ArrayList<>();
        for (Product p:productDao.getEnable()){
            list.add(new ProductDto(p));
        }
        return list;
    }

    @Override
    public List<ProductDto> getFavorite() {
        List <ProductDto> list = new ArrayList<>();
        for (Product p:productDao.getFavorite()){
            list.add(new ProductDto(p));
        }
        return list;
    }
}
