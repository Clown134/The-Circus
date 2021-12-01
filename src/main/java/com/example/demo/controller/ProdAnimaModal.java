package com.example.demo.controller;

public class ProdAnimaModal {
    private String  modal;
    private String picture;
    private String description;
    private String name;

    public ProdAnimaModal(String modal, String picture, String description, String name) {
        this.modal = modal;
        this.picture = picture;
        this.description = description;
        this.name = name;
    }

    public String  getModal() {
        return modal;
    }

    public void setModal(String modal) {
        this.modal = modal;
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
