package com.example.asus.lanuit;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by shihui on 16/6/2015.
 */
public class home extends Fragment {
    View rootview;
    private TextView textView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootview = inflater.inflate(R.layout.home_ui, container, false);

        View.OnClickListener cameraListener = new View.OnClickListener() {
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.buttonFind:
                        Fragment fragment = new find();
                        FragmentManager fragmentManager = getFragmentManager();
                        fragmentManager.beginTransaction()
                                .replace(R.id.container, fragment)
                                .commit();
                        break;
                    case R.id.buttonChange:
                        ((TextView) getView().findViewById(R.id.textView)).setText("CHANGED YAY!!");
                        break;
                }
            }
        };
        rootview.findViewById(R.id.buttonFind).setOnClickListener(cameraListener);
        rootview.findViewById(R.id.buttonChange).setOnClickListener(cameraListener);
        return rootview;
    }





}
