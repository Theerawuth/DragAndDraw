package com.augmentis.ayp.dnd.Animation;

import android.support.v4.app.Fragment;

import com.augmentis.ayp.dnd.SingleFragmentActivity;

/**
 * Created by Theerawuth on 9/1/2016.
 */
public class SunsetActivity extends SingleFragmentActivity {
    @Override
    protected Fragment onCreateFragment() {
        return SunsetFragment.newInstance();
    }
}
