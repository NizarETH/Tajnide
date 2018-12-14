package com.secret.box.tajnide;

import android.graphics.drawable.Drawable;

public class ElementSwipe {

    private int id;
    private Drawable image;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Drawable getImage() {
        return image;
    }

    public void setImage(Drawable image) {
        this.image = image;
    }

    public ElementSwipe(Drawable image) {
        this.image = image;
    }
}
