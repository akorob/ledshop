package com.spring.persistence.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Andrey on 30.12.2014.
 */
@Entity
@Table(name="reviews")
public class Review implements Serializable {
    private int id;
    private Date date;
    private String username;
    private String text;
    private boolean enable;
    private Product product;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(columnDefinition = "TEXT")
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Column(columnDefinition = "BIT")
    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    @ManyToOne
    @JoinColumn(name="products_id")
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", date=" + date +
                ", username='" + username + '\'' +
                ", text='" + text + '\'' +
                ", enable=" + enable +
                ", product=" + product +
                '}';
    }
}
