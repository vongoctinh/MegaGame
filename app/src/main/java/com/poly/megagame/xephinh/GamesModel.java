package com.poly.megagame.xephinh;

import android.graphics.Bitmap;

public class GamesModel {
    private Bitmap mBitmap;
    private String mIndex;

    public GamesModel(Bitmap mBitmap, String mIndex) {
        this.mBitmap = mBitmap;
        this.mIndex = mIndex;
    }

    public Bitmap getmBitmap() {
        return mBitmap;
    }

    public void setmBitmap(Bitmap mBitmap) {
        this.mBitmap = mBitmap;
    }

    public String getmIndex() {
        return mIndex;
    }

    public void setmIndex(String mIndex) {
        this.mIndex = mIndex;
    }
}
