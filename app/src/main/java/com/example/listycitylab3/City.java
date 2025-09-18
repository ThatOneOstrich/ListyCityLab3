package com.example.listycitylab3;

import androidx.annotation.NonNull;

public class City {
    private String cityName;
    private String stateAbbreviation;

    public City(String name, String abbreviation) {
        this.cityName = name;
        this.stateAbbreviation = abbreviation;
    }

    // Getters and setters for cityName and stateAbbreviation
    public String getCityName() {
        return cityName;
    }

    public String getStateAbbreviation() {
        return stateAbbreviation;
    }

    public void setCityName(String name) {
        this.cityName = name;
    }

    public void setStateAbbreviation(String abbreviation) {
        this.stateAbbreviation = abbreviation;
    }

    @NonNull
    @Override
    public String toString() {
        return cityName + "    " + stateAbbreviation;
    }
}
