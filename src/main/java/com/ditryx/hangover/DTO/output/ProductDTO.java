package com.ditryx.hangover.DTO.output;

import com.ditryx.hangover.entities.Product;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ProductDTO {
    private long id;
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

    public ProductDTO() {
    }

    @JsonCreator
    public ProductDTO(@JsonProperty("whiskeyType") String whiskeyType,
                      @JsonProperty("name") String name,
                      @JsonProperty("age") String age,
                      @JsonProperty("country") String country,
                      @JsonProperty("producer") String producer,
                      @JsonProperty("colour") String colour,
                      @JsonProperty("price") double price,
                      @JsonProperty("stock") int stock,
                      @JsonProperty("description") String description) {
        this.whiskeyType = whiskeyType;
        this.name = name;
        this.age = age;
        this.country = country;
        this.producer = producer;
        this.colour = colour;
        this.price = price;
        this.stock = stock;
        this.description = description;
    }

    public Product toEntity(){
        return new Product(whiskeyType,name,age,country,producer,colour,price,stock,description,imgSrc);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getWhiskeyType() {
        return whiskeyType;
    }

    public void setWhiskeyType(String whiskeyType) {
        this.whiskeyType = whiskeyType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }
}
