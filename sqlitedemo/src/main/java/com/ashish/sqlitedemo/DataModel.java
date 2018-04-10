package com.ashish.sqlitedemo;

public class DataModel {

    String name;
    String pass;

    public DataModel(String name, String pass) {
        this.name = name;
        this.pass = pass;
    }

    public DataModel(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @Override
    public String toString() {
        return "DataModel{" +
                "name='" + name + '\'' +
                ", pass='" + pass + '\'' +
                '}';
    }
}


