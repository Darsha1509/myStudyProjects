package com.example.dasha.recyclerviewoptionsmenu;

/**
 * Created by Dasha on 24.07.2017.
 */

public class RecycleItem {
    private String title;
    private String description;

    public RecycleItem(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
