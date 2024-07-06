package com.example.groceryapp;

public class Item {
    private String title;
    private String desc;
    private int image;

    public Item(String title, String desc, int image){
        this.title = title;
        this.desc = desc;
        this.image = image;
    }

    public int getImage() {
        return image;
    }

    public String getDesc() {
        return desc;
    }

    public String getTitle() {
        return title;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
