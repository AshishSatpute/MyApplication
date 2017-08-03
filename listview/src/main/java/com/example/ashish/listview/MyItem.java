package com.example.ashish.listview;

/**
 * Created by Ashish on 8/1/2017.
 */

public class MyItem {
    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    int image;
    String name;

    public MyItem(int image, String name) {
        this.image = image;
        this.name = name;
    }



}
