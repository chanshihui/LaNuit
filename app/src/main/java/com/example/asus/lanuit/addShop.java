package com.example.asus.lanuit;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;

/**
 * Created by shihui on 23/7/2015.
 */
public class addShop extends Fragment {
    View rootview;
    CheckBox checkBox;
    EditText txtMon;
    EditText txtTues;
    EditText txtWed;
    EditText txtThurs;
    EditText txtFri;
    EditText txtSat;
    EditText txtSun;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootview = inflater.inflate(R.layout.addshop_ui, container, false);

        checkBox = (CheckBox) rootview.findViewById(R.id.cbApply);
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if (checkBox.isChecked()) {
                    txtMon = (EditText) rootview.findViewById(R.id.txtMon);
                    String monVar = txtMon.getText().toString();
                    txtTues = (EditText) rootview.findViewById(R.id.txtTues);
                    txtTues.setText(monVar);
                    txtWed = (EditText) rootview.findViewById(R.id.txtWed);
                    txtWed.setText(monVar);
                    txtThurs = (EditText) rootview.findViewById(R.id.txtThurs);
                    txtThurs.setText(monVar);
                    txtFri = (EditText) rootview.findViewById(R.id.txtFri);
                    txtFri.setText(monVar);
                    txtSat = (EditText) rootview.findViewById(R.id.txtSat);
                    txtSat.setText(monVar);
                    txtSun = (EditText) rootview.findViewById(R.id.txtSun);
                    txtSun.setText(monVar);

                } else {
                    txtTues = (EditText) rootview.findViewById(R.id.txtTues);
                    txtTues.setText("");
                    txtWed = (EditText) rootview.findViewById(R.id.txtWed);
                    txtWed.setText("");
                    txtThurs = (EditText) rootview.findViewById(R.id.txtThurs);
                    txtThurs.setText("");
                    txtFri = (EditText) rootview.findViewById(R.id.txtFri);
                    txtFri.setText("");
                    txtSat = (EditText) rootview.findViewById(R.id.txtSat);
                    txtSat.setText("");
                    txtSun = (EditText) rootview.findViewById(R.id.txtSun);
                    txtSun.setText("");
                }
            }
        });
      /*  System.out.println("super size: " + supperList.listOfSupper.size() + " supper name size" + supperList.supperName.size() );
        ListAdapter supperList = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, supper.supperName);
        ListView supperListView = (ListView)rootview.findViewById(R.id.supperList);
        supperListView.setAdapter(supperList);
        supperListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                                  @Override
                                                  public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                                      long cast = parent.getItemIdAtPosition(position);
                                                      int indicator = (int) cast;
                                                      System.out.println(indicator);

                                                      supper.arrayIndicator = indicator;

                                                      Fragment fragment = new supperDetails();
                                                      FragmentManager fragmentManager = getFragmentManager();
                                                      fragmentManager.beginTransaction().replace(R.id.container, fragment).commit();
                                                  }
                                              }
        );

        View.OnClickListener cameraListener = new View.OnClickListener() {
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.btnAdd:
                        Fragment fragment = new register();
                        FragmentManager fragmentManager = getFragmentManager();
                        fragmentManager.beginTransaction()
                                .replace(R.id.container, fragment)
                                .commit();
                        break;
                }
            }
        };
        rootview.findViewById(R.id.btnAdd).setOnClickListener(cameraListener);*/

        return rootview;
    }
}
