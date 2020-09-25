package com.ditryx.hangover.entities;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name="products")
public class Product extends BaseEntity{

    private String whiskeyType;
    private String name;
    private String age;
    private String country;
    private String producer;
    private String colour;
    private double price;
    private int stock;
    private String description;
    private String imgSrc;

    public Product() {
    }

    public Product(String whiskeyType, String name, String age, String country, String producer,
                   String colour, double price, int stock, String description, String imgSrc) {
        this.whiskeyType = whiskeyType;
        this.name = name;
        this.age = age;
        this.country = country;
        this.producer = producer;
        this.colour = colour;
        this.price = price;
        this.stock = stock;
        this.description = description;
        this.imgSrc = imgSrc;
    }

    @Column (name = "")
    public String getWhiskeyType() {
        return whiskeyType;
    }

    public void setWhiskeyType(String whiskeyType) {
        this.whiskeyType = whiskeyType;
    }

    @Column (name = "")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column (name = "")
    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Column (name = "")
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Column (name = "")
    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    @Column (name = "")
    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    @Column (name = "")
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Column (name = "")
    public int getStock() {
        return stock;
    }

    public void setStock(int quantity) {
        this.stock = quantity;
    }

    @Column (name = "")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column (name = "")
    public String getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }
}
