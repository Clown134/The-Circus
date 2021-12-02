package com.example.demo.enities;

import javax.persistence.*;

@Entity
@Table(name = "product")
public class ProductAnimal {

    @Id
    @GeneratedValue
    private Long id;

    @Transient
    private Integer numberPurchases = 0;

    private String modal;

    private String picture;

    private String description;

    private String name;

    public ProductAnimal() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumberPurchases() {
        return numberPurchases;
    }

    public void setNumberPurchases(Integer numberPurchases) {
        this.numberPurchases = numberPurchases;
    }

    public String getModal() {
        return modal;
    }

    public void setModal(String modal) {
        this.modal = modal;
    }

    public String getPicture() {
        return picture;
    }

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
