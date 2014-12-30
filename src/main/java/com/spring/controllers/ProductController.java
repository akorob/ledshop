package com.spring.controllers;

/**
 * Created by Andrey on 26.12.2014.
 */
import java.util.List;

import com.spring.model.ProductDto;
import com.spring.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping(value="/getAll", method = RequestMethod.GET)
    public ResponseEntity getAll() {
        List<ProductDto> list = productService.getAll();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @RequestMapping(value="/getEnable", method = RequestMethod.GET)
    public ResponseEntity getEnable() {
        List<ProductDto> list = productService.getEnable();
        return new ResponseEntity(list, HttpStatus.OK);
    }

 @RequestMapping(value="/get", method = RequestMethod.GET)
    public ResponseEntity get()  {
        List<ProductDto> list = productService.getAll();
 //     return new ResponseEntity("ffffff", HttpStatus.NOT_ACCEPTABLE);
        return new ResponseEntity(list, HttpStatus.OK);
    }




}
