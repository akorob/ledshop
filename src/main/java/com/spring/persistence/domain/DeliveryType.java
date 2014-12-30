package com.spring.persistence.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;

/**
 * Created by Andrey on 30.12.2014.
 */
@Entity
@Table(name="delivery_types")
public class DeliveryType implements Serializable {
    private int id;
    private String name;
    private boolean enable;
    private String description;
    private int position;
    private Order order;
    private Collection<DeliveryOption> deliveryOptions = new HashSet<>();

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    @ManyToOne
    @JoinColumn(name="orders_id")
    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @OneToMany(mappedBy = "deliveryType")
    public Collection<DeliveryOption> getDeliveryOptions() {
        return deliveryOptions;
    }

    public void setDeliveryOptions(Collection<DeliveryOption> deliveryOptions) {
        this.deliveryOptions = deliveryOptions;
    }

    @Override
    public String toString() {
        return "DeliveryType{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", enable=" + enable +
                ", description='" + description + '\'' +
                ", position=" + position +
                ", order=" + order +
                '}';
    }
}
