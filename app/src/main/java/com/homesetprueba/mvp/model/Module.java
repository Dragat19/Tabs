package com.homesetprueba.mvp.model;


import java.io.Serializable;
import java.util.ArrayList;

public class Module implements Serializable {

    private String name;
    private String icon;
    private String id_cat;
    private String category;
    private ArrayList<Element> posts;
    private BasicInfo basicInfo;

    public String getName() {
        return name;
    }

    public String getIcon() {
        return icon;
    }

    public String getId_cat() {
        return id_cat;
    }

    public ArrayList<Element> getPosts() {
        return posts;
    }

    public String getCategory() {
        return category;
    }

    public BasicInfo getBasicInfo() {
        basicInfo = new BasicInfo();
        basicInfo.setIdCat(this.id_cat);
        basicInfo.setName(this.name);
        return basicInfo;
    }

}
