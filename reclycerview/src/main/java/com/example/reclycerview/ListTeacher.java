package com.example.reclycerview;

import java.util.List;

/**
 * Created by ashish on 15/1/18.
 */

public class ListTeacher {

    private String id;
    private List<String> teacher;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<String> getTeacher() {
        return teacher;
    }

    public void setTeacher(List<String> teacher) {
        this.teacher = teacher;
    }

    @Override
    public String toString() {
        return "ListTeacher{" +
                "id='" + id + '\'' +
                ", teacher=" + teacher +
                '}';
    }
}
