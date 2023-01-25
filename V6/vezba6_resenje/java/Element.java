package com.example.customadapter;

import android.graphics.drawable.Drawable;

public class Element {
    private String mText;
    private Drawable mImage;
    private boolean checkText;

    public Element(String mText, Drawable mImage) {
        this.mText = mText;
        this.mImage = mImage;
        this.checkText = false;
    }

    public boolean isCheckText() {
        return checkText;
    }

    public void setCheckText(boolean checkText) {
        this.checkText = checkText;
    }

    public Drawable getmImage() {
        return mImage;
    }

    public void setmImage(Drawable mImage) {
        this.mImage = mImage;
    }

    public String getmText() {
        return mText;
    }

    public void setmText(String mText) {
        this.mText = mText;
    }
}
