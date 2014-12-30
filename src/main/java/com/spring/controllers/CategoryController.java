package com.spring.controllers;

import com.spring.model.CategoryDto;
import com.spring.model.ProductDto;
import com.spring.service.CategoryService;
import com.spring.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Andrey on 30.12.2014.
 */
@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value="/getEnable", method = RequestMethod.GET)
    public ResponseEntity getAll() {
        List<CategoryDto> list = categoryService.getEnable();
        return new ResponseEntity(list, HttpStatus.OK);
    }
}
