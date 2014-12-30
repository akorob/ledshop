package com.spring.persistence.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Created by Andrey on 29.12.2014.
 */
@Entity
@Table( name = "medias" )
public class Media implements Serializable {
    private  int id;
    private long size;
    private String name;
    private Date date;
    private Product product;
    private String data;
    private boolean enable;

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
    @JoinColumn(name = "product_id")
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Column(columnDefinition = "TEXT")
    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Column(columnDefinition = "BIT")
    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    @Override
    public String toString() {
        return "Media{" +
                "id=" + id +
                ", size=" + size +
                ", name='" + name + '\'' +
                ", date=" + date +
                ", product=" + product +
                ", data='" + data + '\'' +
                ", enable=" + enable +
                '}';
    }
}
