package com.example.android.miwok;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;

/**
 * Created by Dasha on 25.08.2017.
 */

public class Word {
    private String mDefaultTranslation;

    private String mMiworkTranslation;

    private int mImageResource = 0;

    private int mAudioResourceId;



    public Word(String defaultTranslation, String miworkTranslation, int audioResourceId) {
        mDefaultTranslation = defaultTranslation;
        mMiworkTranslation = miworkTranslation;
        mAudioResourceId = audioResourceId;
    }

    public Word(String defaultTranslation, String miworkTranslation, int imageResource, int audioResourceId) {
        mDefaultTranslation = defaultTranslation;
        mMiworkTranslation = miworkTranslation;
        mImageResource = imageResource;
        mAudioResourceId = audioResourceId;
    }

    public String getDefaultTranslation() {
        return mDefaultTranslation;
    }

    public String getMiworkTranslation() {
        return mMiworkTranslation;
    }

    public int getImageResource() {
        return mImageResource;
    }

    public int getAudioResourceId() {
        return mAudioResourceId;
    }
}
