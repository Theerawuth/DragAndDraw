package com.augmentis.ayp.dnd.DragAndDraw;

import android.graphics.PointF;

/**
 * Created by Theerawuth on 8/30/2016.
 */
public class Box {
    PointF mStart;
    PointF mEnd;

    public PointF getmStart() {
        return mStart;
    }

    public void setmStart(PointF mStart) {
        this.mStart = mStart;
    }

    public PointF getmEnd() {
        return mEnd;
    }

    public void setmEnd(PointF mEnd) {
        this.mEnd = mEnd;
    }
}
