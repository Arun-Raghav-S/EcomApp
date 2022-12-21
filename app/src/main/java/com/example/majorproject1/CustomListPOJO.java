package com.example.majorproject1;

public class CustomListPOJO {
    int prof;
    String title,desc,price;

    public CustomListPOJO(int prof, String title, String desc, String price) {
        this.prof = prof;
        this.title = title;
        this.desc = desc;
        this.price = price;
    }

    public int getProf() {
        return prof;
    }

    public void setProf(int prof) {
        this.prof = prof;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
