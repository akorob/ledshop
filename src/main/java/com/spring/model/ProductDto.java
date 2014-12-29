package com.spring.model;

import com.spring.persistence.domain.Product;

import java.io.Serializable;

/**
 * Created by Andrey on 29.12.2014.
 */
public class ProductDto implements Serializable {
    private String name;
    private int id;
    private String categoryName;
    private String shortDescr;
    private String longDescr;

    public ProductDto(){}

    public ProductDto(Product product){
        this.name = product.getName();
        this.categoryName = product.getCategory().getName();
        this.id = product.getId();
        this.shortDescr = product.getShortDescr();
        this.longDescr = product.getLongDescr();

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getShortDescr() {
        return shortDescr;
    }

    public void setShortDescr(String shortDescr) {
        this.shortDescr = shortDescr;
    }

    public String getLongDescr() {
        return longDescr;
    }

    public void setLongDescr(String longDescr) {
        this.longDescr = longDescr;
    }
}
