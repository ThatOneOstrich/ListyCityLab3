package com.example.listycitylab3;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class City implements Serializable {

    private String cityName;
    private String stateAbbreviation;

    public City(String name, String abbreviation) {
        this.cityName = name;
        this.stateAbbreviation = abbreviation;
    }

    // Getters and setters
    public String getCityName() {
        return this.cityName;
    }
    public void setCityName(String newCityName) {
        this.cityName = newCityName;
    }

    public String getCityAbbreviation() {
        return this.stateAbbreviation;
    }
    public void setCityAbbreviation(String newCityAbbreviation) {
        this.stateAbbreviation = newCityAbbreviation;
    }

    // implement toString to print out the string correctly
    @NonNull
    @Override
    public String toString() {
        return cityName + "    " + stateAbbreviation;
    }


}
