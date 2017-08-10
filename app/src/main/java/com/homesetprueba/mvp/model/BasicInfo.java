package com.homesetprueba.mvp.model;


import java.io.Serializable;

public class BasicInfo implements Serializable {
    private String name;
    private String id_cat;

    public String getName() {
        return name;
    }

    public String getId_cat() {
        return id_cat;
    }

    public void setIdCat(String idCat) {
        this.id_cat = idCat;
    }

    public void setName(String name) {
        this.name = name;
    }
}