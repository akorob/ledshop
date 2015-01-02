package com.spring.controllers;

/**
 * Created by Andrey on 26.12.2014.
 */
import java.util.ArrayList;
import java.util.List;

import com.spring.model.ProductDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;



@RequestMapping("/product")
@RestController
public class ProductController{

    @PersistenceContext
    private EntityManager em;

    @RequestMapping(value="/getAll", method = RequestMethod.GET)
    public ResponseEntity getAll() {
        List<ProductDto> list = em.createQuery(
                "SELECT new com.spring.model.ProductDto(p) FROM Product p ORDER BY p.position",
                ProductDto.class).getResultList();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @RequestMapping(value="/getEnable", method = RequestMethod.GET)
    public ResponseEntity getEnable() {
        List<ProductDto> list = em.createQuery(
                "SELECT new com.spring.model.ProductDto(p) FROM Product p " +
                        "WHERE p.enable=true ORDER BY p.position",
                ProductDto.class).getResultList();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @RequestMapping(value="/getFavorite", method = RequestMethod.GET)
    public ResponseEntity getFavourite() {
        List<ProductDto> list  = em.createQuery(
                "SELECT new com.spring.model.ProductDto(fp.product) " +
                        "FROM FavoriteProduct fp " +
                        "ORDER BY fp.position"
                , ProductDto.class).getResultList();
        return new ResponseEntity(list, HttpStatus.OK);
    }








}
