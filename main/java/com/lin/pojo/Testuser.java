package com.lin.pojo;

public class Testuser {
    int id;
    int price;
    String details;

    public Testuser() {
    }

    public Testuser(int id, int price, String detail) {
        this.id = id;
        this.price = price;
        this.details = detail;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDetail() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
