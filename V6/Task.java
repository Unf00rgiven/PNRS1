package com.example.vezba6;

import android.graphics.drawable.Drawable;

public class Task {

    Drawable mImage;
    String mText;
    Boolean mCheckBox;

    public Task(String mText, Boolean mCheckBox) {
        this.mImage = mImage;
        this.mText = mText;
        this.mCheckBox = mCheckBox;
    }

    public Task(MainActivity mainActivity) {
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

    public Boolean getmCheckBox() {
        return mCheckBox;
    }

    public void setmCheckBox(Boolean mCheckBox) {
        this.mCheckBox = mCheckBox;
    }
}
