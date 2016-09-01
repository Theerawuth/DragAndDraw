package com.augmentis.ayp.dnd.DragAndDraw;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Theerawuth on 8/30/2016.
 */
public class BoxDrawingView extends View {

    private static final String TAG = "BoxDrawingView";

    private Box mCurrentBox;
    private List<Box> mBoxList = new ArrayList<>();
    private Paint mBackgroundPaint;
    private Paint mBoxPaint;

    public BoxDrawingView(Context context) {
        super(context, null);
    }

    public BoxDrawingView(Context context, AttributeSet attrs) {
        super(context, attrs);

        mBoxPaint = new Paint();
        mBoxPaint.setColor(0x22ff0000);

        mBackgroundPaint = new Paint();
        mBackgroundPaint.setColor(0xfff8efe0);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawPaint(mBackgroundPaint);

        for(Box box : mBoxList) {
            float left = Math.min( box.getmStart().x, box.getmEnd().x);
            float top = Math.min( box.getmStart().y, box.getmEnd().y );
            float right = Math.max( box.getmStart().x, box.getmEnd().x );
            float bottom = Math.max ( box.getmStart().x, box.getmEnd().y );

            canvas.drawRect(left, top, right, bottom, mBoxPaint);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        PointF currentPoint  = new PointF(event.getX(), event.getY());
        String action = "NO";

        switch (event.getAction()){
            case MotionEvent.ACTION_MOVE:
                action = "ACTION_MOVE";
                if(mCurrentBox != null) {
                    mCurrentBox.setmEnd(currentPoint);
                    invalidate(); // force to re-draw
                    logBox(mCurrentBox);
                }
                break;
            case MotionEvent.ACTION_DOWN:
                action = "ACTION_DOWN";
                mCurrentBox = new Box();
                mCurrentBox.setmStart(currentPoint);
                mBoxList.add(mCurrentBox);
                break;
            case MotionEvent.ACTION_UP:
                action = "ACTION_UP";
                mCurrentBox = null;
                break;
            case MotionEvent.ACTION_CANCEL:
                action = "ACTION_CANCEL";
                mCurrentBox = null;
                break;
        }

        Log.d(TAG, "Action = " + action + "// at XY = " + currentPoint.x + "," + currentPoint.y);

        return true;
    }

    private void logBox(Box box) {
        if(box != null){

            Log.d(TAG, "CurrentBox: " + box.toString() + ", start =" + box.getmStart() + ", end =" + box.getmEnd());

        }

    }
}
