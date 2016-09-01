package com.augmentis.ayp.dnd.DragAndDraw;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.augmentis.ayp.dnd.R;

/**
 * Created by Theerawuth on 8/30/2016.
 */
public class DragAndDrawFragment extends Fragment {

    public static DragAndDrawFragment newInstance() {

        Bundle args = new Bundle();

        DragAndDrawFragment fragment = new DragAndDrawFragment();
        fragment.setArguments(args);
        return fragment;
    }

    ////////
    BoxDrawingView mBoxDrawingView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_point_finger,container,false);
//        mBoxDrawingView = (BoxDrawingView) v.findViewById(R.id.box_drawing_view);

        return v;
    }
}
