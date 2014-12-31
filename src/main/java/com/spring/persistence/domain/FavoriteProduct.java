package com.spring.persistence.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Andrey on 31.12.2014.
 */
@Entity
@Table(name="favorite_products")
public class FavoriteProduct implements Serializable {
    private int id;
    private int position;
    private Product product;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    @ManyToOne
    @JoinColumn(name="products_id")
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
