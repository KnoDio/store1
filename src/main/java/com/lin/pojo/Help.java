package com.lin.pojo;

public class Help {
    int uid;
    String helpmessage;
    String responmessage;
    String details;
    int id;

    public Help() {
    }

    public Help(int uid, String helpmessage, String responmessage, String details, int id) {
        this.uid = uid;
        this.helpmessage = helpmessage;
        this.responmessage = responmessage;
        this.details = details;
        this.id = id;
    }

    public String getDetails() {
        return details;
    }

    @Override
    public String toString() {
        return "Help{" +
                "uid=" + uid +
                ", helpmessage='" + helpmessage + '\'' +
                ", responmessage='" + responmessage + '\'' +
                ", details='" + details + '\'' +
                ", id=" + id +
                '}';
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

    public String getHelpmessage() {
        return helpmessage;
    }

    public void setHelpmessage(String helpmessage) {
        this.helpmessage = helpmessage;
    }

    public String getResponmessage() {
        return responmessage;
    }

    public void setResponmessage(String responmessage) {
        this.responmessage = responmessage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
