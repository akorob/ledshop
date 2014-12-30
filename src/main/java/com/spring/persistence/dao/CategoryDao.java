package com.spring.persistence.dao;

import com.spring.persistence.domain.Category;

import java.util.List;

/**
 * Created by Andrey on 30.12.2014.
 */
public interface CategoryDao {
    List<Category> getEnable();

    List<Category> getAll();
}
