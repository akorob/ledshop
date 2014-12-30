package com.spring.persistence.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;

/**
 * Created by Andrey on 30.12.2014.
 */
@Entity
@Table(name="orders")
public class Order implements Serializable{
    private int id;
    private String uuid;
    private int pin;
    private String comment;
    private Date date;
    private Date closeDate;
    private BigDecimal price;
    private BigDecimal deliveryPrice;
    private OrderDetail orderDetail;
    private Collection<PaymentType> paymentTypes = new HashSet<>();
    private Collection<DeliveryType> deliveryTypes = new HashSet<>();
    private Collection<Customer> customers = new HashSet<>();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name="order_uuid")
    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Column(name="close_date")
    public Date getCloseDate() {
        return closeDate;
    }

    public void setCloseDate(Date closeDate) {
        this.closeDate = closeDate;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Column(name="delivery_price")
    public BigDecimal getDeliveryPrice() {
        return deliveryPrice;
    }

    public void setDeliveryPrice(BigDecimal deliveryPrice) {
        this.deliveryPrice = deliveryPrice;
    }


    @ManyToOne
    @JoinColumn(name="order_details_id")
    public OrderDetail getOrderDetail() {
        return orderDetail;
    }

    public void setOrderDetail(OrderDetail orderDetail) {
        this.orderDetail = orderDetail;
    }

    @OneToMany(mappedBy = "order")
    public Collection<PaymentType> getPaymentTypes() {
        return paymentTypes;
    }

    public void setPaymentTypes(Collection<PaymentType> paymentTypes) {
        this.paymentTypes = paymentTypes;
    }

    @OneToMany(mappedBy = "order")
    public Collection<DeliveryType> getDeliveryTypes() {
        return deliveryTypes;
    }

    public void setDeliveryTypes(Collection<DeliveryType> deliveryTypes) {
        this.deliveryTypes = deliveryTypes;
    }

    @OneToMany(mappedBy = "order")
    public Collection<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(Collection<Customer> customers) {
        this.customers = customers;
    }
}
