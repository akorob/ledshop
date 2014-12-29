package com.spring.persistence.domain;

import org.hibernate.validator.cfg.defs.DecimalMaxDef;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Created by Andrey on 29.12.2014.
 */
@Entity
@Table(name="price")
public class Price {
    private int id;
    private BigDecimal price;
    private Date date;
    private boolean isActive;
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

    @Column(name="active", columnDefinition = "BIT", length = 1)
    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="product_id")
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
