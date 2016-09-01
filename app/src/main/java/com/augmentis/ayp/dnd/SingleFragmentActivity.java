package com.augmentis.ayp.dnd;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.augmentis.ayp.dnd.R;

public abstract class SingleFragmentActivity extends AppCompatActivity {


    private static final String TAG = "SingleFragmentActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_fragment);

        Log.d(TAG, "On Create Activity");

        FragmentManager fm = getSupportFragmentManager();
        Fragment f = fm.findFragmentById(R.id.alone_fragment);

        if(f == null) {
            f = onCreateFragment();

            fm.beginTransaction()
                    .add(R.id.alone_fragment, f)
                    .commit();
            Log.d(TAG, "Fragment is created");
        }
        else
        {
            Log.d(TAG, "Fragment have already been created");
        }
    }

    protected abstract Fragment onCreateFragment();

    }

