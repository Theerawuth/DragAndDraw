package com.augmentis.ayp.dnd;

import android.support.v4.app.Fragment;

/**
 * Created by Theerawuth on 8/30/2016.
 */
public class DragAndDrawActivity extends SingleFragmentActivity {
    @Override
    protected Fragment onCreateFragment() {

        return DragAndDrawFragment.newInstance();
    }
}
