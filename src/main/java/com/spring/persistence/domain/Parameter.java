package com.spring.persistence.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;

/**
 * Created by Andrey on 30.12.2014.
 */
@Entity
@Table(name="parameters")
public class Parameter implements Serializable {
    private int id;
    private String name;
    private boolean enable;
    private int position;
    private Collection<ParameterOfProduct> parameterOfProductCollection = new HashSet<>();

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

    @OneToMany(mappedBy = "parameter")
    public Collection<ParameterOfProduct> getParameterOfProductCollection() {
        return parameterOfProductCollection;
    }

    public void setParameterOfProductCollection(Collection<ParameterOfProduct> parameterOfProductCollection) {
        this.parameterOfProductCollection = parameterOfProductCollection;
    }

    @Override
    public String toString() {
        return "Parameter{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", enable=" + enable +
                ", position=" + position +
                ", parameterOfProductCollection=" + parameterOfProductCollection +
                '}';
    }
}
