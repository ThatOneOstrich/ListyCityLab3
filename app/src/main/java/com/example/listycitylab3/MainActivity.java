package com.example.listycitylab3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private ArrayList<City> dataList;
    private ListView cityList;
    private ArrayAdapter<City> cityAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        City edmonton = new City("Edmonton", "AB");
        City vancouver = new City("Vancouver", "BC");
        City toronto = new City("Toronto", "ON");
        City hamilton = new City("Hamilton", "ON");
        City denver = new City("Denver", "CO");
        City losAngeles = new City("Los Angeles", "CA");

        // add all the city objects to dataList
        dataList = new ArrayList<>();
        dataList.add(edmonton);
        dataList.add(vancouver);
        dataList.add(toronto);
        dataList.add(hamilton);
        dataList.add(denver);
        dataList.add(losAngeles);

        // set up array adapter and list view
        cityList = findViewById(R.id.city_list);
        cityAdapter = new ArrayAdapter<>(this, R.layout.content, dataList);
        cityList.setAdapter(cityAdapter);

        // set up onitemclicklistener for list view
        cityList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                City selectedCity = cityAdapter.getItem(position);
            }
        });
    }
}