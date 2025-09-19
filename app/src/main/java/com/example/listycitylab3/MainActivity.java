package com.example.listycitylab3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity implements AddEditDialog.UpdateCity {

    private ArrayList<City> dataList;
    private ListView cityList;
    private ArrayAdapter<City> cityAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // create cities
        City edmonton = new City("Edmonton", "AB");
        City vancouver = new City("Vancouver", "BC");
        City toronto = new City("Toronto", "ON");
        City hamilton = new City("Hamilton", "ON");
        City denver = new City("Denver", "CO");
        City losAngeles = new City("Los Angeles", "CA");

        // add cities to datalist
        dataList = new ArrayList<>();
        dataList.addAll(Arrays.asList(edmonton, vancouver, toronto, hamilton, denver, losAngeles));

        cityList = findViewById(R.id.city_list);
        cityAdapter = new ArrayAdapter<>(this, R.layout.content, dataList);
        cityList.setAdapter(cityAdapter);

        cityList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            City selectedCity;
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectedCity = dataList.get(position);
                AddEditDialog addEditDialog = new AddEditDialog().newInstance(selectedCity, position);
                addEditDialog.show(getSupportFragmentManager(), "AddEditDialog");
            }
        });

    }
    public void editCity(City updatedCity, int position) {
        dataList.set(position, updatedCity);
        cityAdapter.notifyDataSetChanged();
    }
}