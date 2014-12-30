package com.spring.model;

import com.spring.persistence.domain.Category;
import com.spring.persistence.domain.Product;

import java.util.Collection;
import java.util.HashSet;

/**
 * Created by Andrey on 30.12.2014.
 */
public class CategoryDto {
    private int id;
    private String name;
    private String url;
    private boolean enable;
    private int position;

    public CategoryDto(Category category){
        this.id = category.getId();
        this.name = category.getName();
        this.url = category.getUrl();
        this.enable = category.isEnable();
        this.position = category.getPosition();
    }

    public CategoryDto(){}

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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

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

    @Override
    public String toString() {
        return "CategoryDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", enable=" + enable +
                ", position=" + position +
                '}';
    }
}
