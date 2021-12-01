package com.example.demo.controller;

public class ProductAnimal {
    private Integer numberPurchases;
    private String picture;
    private String description;
    private String name;

    public ProductAnimal(Integer numberPurchases, String picture, String description, String name) {
        this.numberPurchases = numberPurchases;
        this.picture = picture;
        this.description = description;
        this.name = name;
    }

    public Integer getNumberPurchases() {
        return numberPurchases;
    }

    public void setNumberPurchases(Integer numberPurchases) {
        this.numberPurchases = numberPurchases;
    }

    public String getPicture() {return picture;}

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
