package com.spring.model;

import com.spring.persistence.domain.Price;
import com.spring.persistence.domain.Product;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;

/**
 * Created by Andrey on 29.12.2014.
 */
public class ProductDto implements Serializable {
    private String name;
    private int id;
    private String categoryName;
    private String shortDescr;
    private String longDescr;
    private BigDecimal price;

    @PersistenceContext
    private EntityManager em;

    public ProductDto(){}

    public ProductDto(Product product){
        this.name = product.getName();
        this.categoryName = product.getCategory().getName();
        this.id = product.getId();
        this.shortDescr = product.getShortDescr();
        this.longDescr = product.getLongDescr();
        Collection<Price> prices = product.getPrices();
        for(Price p : prices){
            if (p.isEnable()){
                this.price = p.getPrice();
            }
        }

        System.out.println(this);

    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
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

    @Override
    public String toString() {
        return "ProductDto{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", categoryName='" + categoryName + '\'' +
                ", shortDescr='" + shortDescr + '\'' +
                ", longDescr='" + longDescr + '\'' +
                ", price=" + price +
                '}';
    }
}
