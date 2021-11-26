package com.lin.pojo;

public class Respon {
    int uid;
    String resmessage;
    String details;
    int id;

    public Respon(int uid, String resmessage, String details, int id) {
        this.uid = uid;
        this.resmessage = resmessage;
        this.details = details;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Respon{" +
                "uid=" + uid +
                ", resmessage='" + resmessage + '\'' +
                ", details='" + details + '\'' +
                ", id=" + id +
                '}';
    }

    public Respon() {
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getResmessage() {
        return resmessage;
    }

    public void setResmessage(String resmessage) {
        this.resmessage = resmessage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
