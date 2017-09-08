package com.example.dasha.homework3;

/**
 * Created by Dasha on 19.07.2017.
 */

public class User {
    private int imageId;
    private String name;
    private String full_name;
    private boolean isActive;

    public User(int imageId, String name, String full_name, boolean isActive){
        this.imageId = imageId;
        this.name = name;
        this.full_name = full_name;
        this.isActive = isActive;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
