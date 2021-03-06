package com.spring.persistence.domain;

import org.hibernate.validator.cfg.defs.DecimalMaxDef;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Created by Andrey on 29.12.2014.
 */
@Entity
@Table(name="prices")
public class Price implements Serializable {
    private int id;
    private BigDecimal price;
    private Date date;
    private boolean enable;
    private Product product;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Column(columnDefinition = "BIT")
    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
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
        return "Price{" +
                "id=" + id +
                ", price=" + price +
                ", date=" + date +
                ", enable=" + enable +
                ", product=" + product +
                '}';
    }
}
