package com.augmentis.ayp.dnd.DragAndDraw;

import android.support.v4.app.Fragment;

import com.augmentis.ayp.dnd.SingleFragmentActivity;

/**
 * Created by Theerawuth on 8/30/2016.
 */
public class DragAndDrawActivity extends SingleFragmentActivity {
    @Override
    protected Fragment onCreateFragment() {

        return DragAndDrawFragment.newInstance();
    }
}
