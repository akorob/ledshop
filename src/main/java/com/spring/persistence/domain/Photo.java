package com.spring.persistence.domain;

import javax.persistence.*;
import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Created by Andrey on 29.12.2014.
 */
@Entity
@Table( name = "photo" )
public class Photo {
    private int id;
    private long size;
    private String name;
    private Date date;
    private Product product;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @ManyToOne
    @JoinColumn(name="product_id")
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "Photo{" +
                "id=" + id +
                ", size=" + size +
                ", name='" + name + '\'' +
                ", date=" + date +
                ", product.getName=" + product.getName() +
                '}';
    }
}
