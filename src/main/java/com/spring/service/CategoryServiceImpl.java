package com.spring.service;

import com.spring.model.CategoryDto;
import com.spring.model.ProductDto;
import com.spring.persistence.dao.CategoryDao;
import com.spring.persistence.domain.Category;
import com.spring.persistence.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by Andrey on 30.12.2014.
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryDao categoryDao;

    @Override
    public List<CategoryDto> getEnable() {
        List <CategoryDto> list = new ArrayList<>();
        for (Category c : categoryDao.getEnable()){
            list.add(new CategoryDto(c));
        }
        return list;
    }
}
