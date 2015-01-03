package com.spring.controllers;

import com.spring.model.CategoryDto;
import com.spring.persistence.domain.Category;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Andrey on 30.12.2014.
 */
@RestController
@RequestMapping("/category")
public class CategoryController {

    @PersistenceContext
    private EntityManager em;

    @RequestMapping(value="/getEnable", method = RequestMethod.GET)
    public ResponseEntity getEnable() {
        List<CategoryDto> list  = em.createQuery(
                "SELECT new com.spring.model.CategoryDto(c) FROM Category  c " +
                        "WHERE c.enable=true ORDER BY c.position"
                , CategoryDto.class).getResultList();

        return new ResponseEntity(list, HttpStatus.OK);
    }
}
