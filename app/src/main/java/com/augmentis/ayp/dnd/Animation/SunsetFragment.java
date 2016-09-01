package com.augmentis.ayp.dnd.Animation;

import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;

import com.augmentis.ayp.dnd.R;

/**
 * Created by Theerawuth on 9/1/2016.
 */
public class SunsetFragment extends Fragment {

    public static SunsetFragment newInstance() {

        Bundle args = new Bundle();

        SunsetFragment fragment = new SunsetFragment();
        fragment.setArguments(args);
        return fragment;
    }

    private View mSceneView;
    private View mSunView;
    private View mSkyView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_sunset, container, false);

        mSceneView = v;
        mSkyView = v.findViewById(R.id.sky);
        mSunView = v.findViewById(R.id.sun);

        mSceneView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startAnimation();
            }
        });
        return v;
    }

    private void startAnimation() {
        float sunYStart = mSunView.getTop();
        float sunHeight = mSunView.getHeight();
        float sunHalfHeight = sunHeight / 2;
        float skyYEnd = mSkyView.getHeight();
//        float sunYEnd = skyYEnd - sunHalfHeight; // half sun

        float sunYEnd = skyYEnd;

        //1.
        ObjectAnimator heightAnimator = ObjectAnimator
                .ofFloat(mSunView, "y", sunYStart, sunYEnd)
                .setDuration(3000);

        //Up Speed
        heightAnimator.setInterpolator(new AccelerateInterpolator());
        //set color
        int colorBlueSky = getResources().getColor(R.color.blue_sky);
        int colorSunsetSky = getResources().getColor(R.color.sunset_sky);
        int colorNightSky = getResources().getColor(R.color.night_sky);

        //2.
        ObjectAnimator sunsetAnimator = ObjectAnimator.ofInt(mSkyView, "backgroundColor",
                colorBlueSky,
                colorSunsetSky).setDuration(1500);

        //บวกค่าสีให้ดูมีเหตุผลทำให้สวยขึ้น
        sunsetAnimator.setEvaluator(new ArgbEvaluator());

        //3.
        ObjectAnimator nightAnimator;
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            nightAnimator = ObjectAnimator.ofArgb(mSkyView,
                    "backgroundColor", colorSunsetSky, colorNightSky)
                    .setDuration(1500);
        } else {
            nightAnimator = ObjectAnimator.ofInt(mSkyView,
                    "backgroundColor", colorSunsetSky, colorNightSky)
                    .setDuration(1500);
            nightAnimator.setEvaluator(new ArgbEvaluator());
        }

        ObjectAnimator biggerXSunAnimator = ObjectAnimator.ofFloat(mSunView,
                "scaleX",
                1f,
                1.5f)
                .setDuration(3000);
        ObjectAnimator biggerYSunAnimator = ObjectAnimator.ofFloat(mSunView,
                "scaleY",
                1f,
                1.5f)
                .setDuration(3000);

        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(heightAnimator)
                .with(biggerXSunAnimator)
                .with(biggerYSunAnimator)
                .with(sunsetAnimator)
                .before(nightAnimator);

        animatorSet.start();
    }


}
