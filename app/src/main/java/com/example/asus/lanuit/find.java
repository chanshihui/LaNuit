package com.example.asus.lanuit;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import com.geocoder.lanuit.GeoCodes;

import android.location.Geocoder;

/**
 * Created by shihui on 16/6/2015.
 */
public class find extends Fragment {
    View rootview;
    Spinner cuisineSpinner;
    EditText priceET;
    Supper supperList;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        rootview = inflater.inflate(R.layout.find_ui, container, false);

        // Define button onClick methods
        View.OnClickListener cameraListener = new View.OnClickListener() {
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.searchBtn:
                        searchSupper();

                        Fragment fragment = new Result();
                        FragmentManager fragmentManager = getFragmentManager();
                        fragmentManager.beginTransaction().replace(R.id.container, fragment).commit();

                        break;
                }
            }
        };
        rootview.findViewById(R.id.searchBtn).setOnClickListener(cameraListener);
        priceET = (EditText)rootview.findViewById(R.id.price);
        cuisineSpinner =(Spinner)rootview.findViewById(R.id.CuisineList);
        return rootview;
    }


    public void searchSupper()
    {
        // Method to search

        RequestParams params = new RequestParams();

        String cuisine = "cuisine = '" + String.valueOf(cuisineSpinner.getSelectedItem()) +"'" ;
        String price = "price <='" + priceET.getText().toString() + "'";
        params.put("cuisine", cuisine);
        params.put("price", price);
        params.put("latitude", "empty");
        params.put("longitude", "empty");
        params.put("dateTime", "empty");
        invokeWS(params);
    }

    // method to call the Json data from the server
    public void invokeWS(RequestParams params)
    {
        AsyncHttpClient client = new AsyncHttpClient();
        // establish connection to webservice
        client.get("http://192.168.1.98:8080/laNuitWS/SearchSupper/Search", params, new JsonHttpResponseHandler()
        {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray response)
            {
                for(int counter = 0; counter < response.length(); counter++)
                {
                    try
                    {
                        JSONObject obj = response.getJSONObject(counter);
                        Supper newSupper = new Supper(obj.getString("name"), obj.getString("address"),obj.getString("postal"),
                                obj.getString("latitude"), obj.getString("longitude"),obj.getString("openHours"),
                                obj.getString("price"), obj.getString("foodType"));
                        supperList.listOfSupper.add(newSupper);
                        supperList.supperName.add(newSupper.getName());

                        //Toast.makeText(getActivity().getApplicationContext(), supperList.listOfSupper.size().toString(), Toast.LENGTH_SHORT).show();
                    }

                    catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

}
