package com.spring.persistence.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Andrey on 30.12.2014.
 */

@Entity
@Table(name="payment_types")
public class PaymentType implements Serializable {
    private int id;
    private String name;
    private boolean enable;
    private int position;
    private String description;
    private Order order;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(columnDefinition = "BIT")
    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @ManyToOne
    @JoinColumn(name="orders_id")
    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "PaymentType{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", enable=" + enable +
                ", position=" + position +
                ", description='" + description + '\'' +
                ", order=" + order +
                '}';
    }
}
