package com.spring.persistence.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Andrey on 30.12.2014.
 */
@Entity
@Table(name="parametrs_products")
public class ParameterOfProduct implements Serializable {
    private int id;
    private String value;
    private Product product;
    private Parameter parameter;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @ManyToOne
    @JoinColumn(name="products_id")
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @ManyToOne
    @JoinColumn(name="parameters_id")
    public Parameter getParameter() {
        return parameter;
    }

    public void setParameter(Parameter parameter) {
        this.parameter = parameter;
    }

    @Override
    public String toString() {
        return "ParameterOfProduct{" +
                "id=" + id +
                ", value='" + value + '\'' +
                ", product=" + product +
                ", parameter=" + parameter +
                '}';
    }
}
