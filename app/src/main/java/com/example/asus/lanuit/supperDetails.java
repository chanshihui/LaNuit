package com.example.asus.lanuit;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by ASUS on 29/6/2015.
 */
public class supperDetails extends Fragment {

    View rootview;
    Supper supperList;
    TextView supperName;
    TextView supperAddress;
    TextView supperPostal;
    TextView supperPrice;
    TextView supperFoodType;


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        rootview = inflater.inflate(R.layout.supper_details, container, false);

        Supper supper = (retrieveSupper(supperList.arrayIndicator));

         supperName = (TextView) rootview.findViewById(R.id.supperName);
         supperAddress = (TextView) rootview.findViewById(R.id.supperAddress);
         supperPostal = (TextView) rootview.findViewById(R.id.supperPostal);
        supperPrice = (TextView) rootview.findViewById(R.id.supperPrice);
         supperFoodType = (TextView) rootview.findViewById(R.id.supperFoodType);

        supperName.setText("Name: " +supper.getName());
        supperAddress.setText("Address: " +supper.getAddress());
        supperPostal.setText("Postal: Singapore "+ supper.getPostal());
        supperPrice.setText("Price: "+ supper.getPrice());
        supperFoodType.setText("Cusines: " + supper.getFoodType() );

        View.OnClickListener cameraListener = new View.OnClickListener() {
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.button2:
                        Fragment fragment = new Result();
                        FragmentManager fragmentManager = getFragmentManager();
                        fragmentManager.beginTransaction().replace(R.id.container, fragment).commit();
                        break;
                }
            }
        };
        rootview.findViewById(R.id.button2).setOnClickListener(cameraListener);

        return rootview;
    }



    public Supper retrieveSupper(int position)
    {
        return supperList.listOfSupper.get(position);
    }

}
