package com.example.dasha.booklistingapp;

/**
 * Created by Dasha on 13.09.2017.
 */

public class Book {
    private String mTitle;
    private String mAuthor;
    private String mImageResouce;

    public Book() {
    }

    public Book(String title, String author) {
        mTitle = title;
        mAuthor = author;
    }

    public Book(String title, String author, String imageResouce) {
        mTitle = title;
        mAuthor = author;
        mImageResouce = imageResouce;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getAuthor() {
        return mAuthor;
    }

    public String getImageResouce() {
        return mImageResouce;
    }
}
