package com.poly.megagame.xephinh;

import android.content.Context;
import android.util.AttributeSet;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

public class CustomGridLayoutManager extends GridLayoutManager {
    private boolean isScrollEnabled = true;

    public CustomGridLayoutManager(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes, boolean isScrollEnabled) {
        super(context, attrs, defStyleAttr, defStyleRes);
        this.isScrollEnabled = isScrollEnabled;
    }

    public CustomGridLayoutManager(Context context, int spanCount, boolean isScrollEnabled) {
        super(context, spanCount);
        this.isScrollEnabled = isScrollEnabled;
    }

    public CustomGridLayoutManager(Context context, int spanCount, int orientation, boolean reverseLayout, boolean isScrollEnabled) {
        super(context, spanCount, orientation, reverseLayout);
        this.isScrollEnabled = isScrollEnabled;
    }

    public void setScrollEnabled(boolean flag) {
        this.isScrollEnabled = flag;
    }

    @Override
    public boolean canScrollVertically() {
        //Similarly you can customize "canScrollHorizontally()" for managing horizontal scroll
        return isScrollEnabled && super.canScrollVertically();
    }
}

