package com.lin.pojo;

import com.sun.javafx.collections.MappingChange;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

public class Shop {
    int id;
    String name;
    int price;
    String details;
    String picture;
    String picture2;
    String picture3;
    String username;
    int loadid;

    public Shop(int id, String name, int price, String details, String picture, String picture2, String picture3, String username, int loadid) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.details = details;
        this.picture = picture;
        this.picture2 = picture2;
        this.picture3 = picture3;
        this.username = username;
        this.loadid = loadid;
    }

    @Override
    public String toString() {
        return "Shop{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", details='" + details + '\'' +
                ", picture='" + picture + '\'' +
                ", picture2='" + picture2 + '\'' +
                ", picture3='" + picture3 + '\'' +
                ", username='" + username + '\'' +
                ", loadid=" + loadid +
                '}';
    }

    public Shop() {
    }

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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getPicture2() {
        return picture2;
    }

    public void setPicture2(String picture2) {
        this.picture2 = picture2;
    }

    public String getPicture3() {
        return picture3;
    }

    public void setPicture3(String picture3) {
        this.picture3 = picture3;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getLoadid() {
        return loadid;
    }

    public void setLoadid(int loadid) {
        this.loadid = loadid;
    }
}
