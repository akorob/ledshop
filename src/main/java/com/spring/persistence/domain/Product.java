package com.spring.persistence.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Created by Andrey on 29.12.2014.
 */
@Entity
@Table( name = "products" )
public class Product implements Serializable {
    private int id;
    private String name;
    private String sku;
    private int position;
    private  String shortDescr;
    private String longDescr;
    private Date date;
    private boolean enable;
    private boolean instock;
    private Category category;
    private Collection<Media> medias = new HashSet<>();
    private Collection<Photo> photos = new HashSet<>();
    private Collection<Price> prices = new HashSet<>();
    private Collection<Review> reviews = new HashSet<>();
    private Collection<OrderDetail> orderDetails = new HashSet<>();
    private Collection<Comment> comments = new HashSet<>();
    private Collection<ParameterOfProduct> parameterOfProductCollection = new HashSet<>();

    @Id
    @GeneratedValue(strategy = IDENTITY)
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

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    @Column(name="shot_descr")
    public String getShortDescr() {
        return shortDescr;
    }

    public void setShortDescr(String shortDescr) {
        this.shortDescr = shortDescr;
    }

    @Column(name="long_descr", columnDefinition = "TEXT")
    public String getLongDescr() {
        return longDescr;
    }

    public void setLongDescr(String longDescr) {
        this.longDescr = longDescr;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @ManyToOne
    @JoinColumn(name = "category_id")
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @OneToMany(mappedBy = "product")
    public Collection<Media> getMedias() {
        return medias;
    }

    public void setMedias(Collection<Media> medias) {
        this.medias = medias;
    }

    @OneToMany(mappedBy = "product")
    public Collection<Photo> getPhotos() {
        return photos;
    }

    public void setPhotos(Collection<Photo> photos) {
        this.photos = photos;
    }

    @OneToMany(mappedBy = "product")
    public Collection<Price> getPrices() {
        return prices;
    }

    public void setPrices(Collection<Price> prices) {
        this.prices = prices;
    }

    @OneToMany(mappedBy = "product")
    public Collection<Review> getReviews() {
        return reviews;
    }

    public void setReviews(Collection<Review> reviews) {
        this.reviews = reviews;
    }

    @OneToMany(mappedBy = "product")
    public Collection<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(Collection<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }

    @OneToMany(mappedBy = "product")
    public Collection<Comment> getComments() {
        return comments;
    }

    public void setComments(Collection<Comment> comments) {
        this.comments = comments;
    }

    @OneToMany(mappedBy = "product")
    public Collection<ParameterOfProduct> getParameterOfProductCollection() {
        return parameterOfProductCollection;
    }

    public void setParameterOfProductCollection(Collection<ParameterOfProduct> parameterOfProductCollection) {
        this.parameterOfProductCollection = parameterOfProductCollection;
    }

    @Column(columnDefinition = "BIT")
    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    @Column(columnDefinition = "BIT")
    public boolean isInstock() {
        return instock;
    }

    public void setInstock(boolean instock) {
        this.instock = instock;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sku='" + sku + '\'' +
                ", position=" + position +
                ", shortDescr='" + shortDescr + '\'' +
                ", longDescr='" + longDescr + '\'' +
                ", date=" + date +
                ", enable=" + enable +
                ", instock=" + instock +
                ", category=" + category +
                ", medias=" + medias +
                ", photos=" + photos +
                ", prices=" + prices +
                ", reviews=" + reviews +
                ", orderDetails=" + orderDetails +
                ", comments=" + comments +
                ", parameterOfProductCollection=" + parameterOfProductCollection +
                '}';
    }
}
