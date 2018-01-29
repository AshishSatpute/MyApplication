package com.example.recyclerdailogprogress;

/**
 * Created by ashish on 16/1/18.
 */

public class ListItem {
    private String name;
    private String email;
    public String image;



    public ListItem(String name, String email, String image) {
        this.name = name;
        this.email = email;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}