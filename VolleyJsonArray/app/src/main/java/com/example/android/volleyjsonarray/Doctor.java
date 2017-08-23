package com.example.android.volleyjsonarray;

/**
 * Created by ReaL PC on 11/20/2016.
 */

public class Doctor {
    private int id;
    private String name;
    //private String description;

    public Doctor() {
    }

    public Doctor(int id, String name) {
        this.id = id;
        this.name = name;
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

    @Override
    public String toString() {
        return "Doctor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
