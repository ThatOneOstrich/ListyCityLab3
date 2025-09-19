package com.example.listycitylab3;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class AddEditDialog extends DialogFragment {

    public interface UpdateCity {
        void editCity(City udpatedCity, int position);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View addEditDialogLayout = inflater.inflate(R.layout.addeditdialog, container, false);

        return addEditDialogLayout;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        City selectedCity = (City) getArguments().getSerializable("city");
        int position = getArguments().getInt("position");
        String cityName = selectedCity.getCityName();
        String cityAbbreviation = selectedCity.getCityAbbreviation();

        // get the edit text sections
        EditText editCity = view.findViewById(R.id.edit_city_editview);
        EditText editAbbreviation = view.findViewById(R.id.edit_state_editview);

        // get confirmation buttons
        Button cancelButton = view.findViewById(R.id.cancel_button);
        Button okayButton = view.findViewById(R.id.okay_button);

        // set the edit text fields to appropriate values
        editCity.setText(cityName);
        editAbbreviation.setText(cityAbbreviation);

        // make the cancel button functional
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        // make the ok button functional
        okayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String updatedCityName = editCity.getText().toString();
                String updatedCityAbbreviation = editAbbreviation.getText().toString();

                City updatedCity = new City(updatedCityName, updatedCityAbbreviation);
                UpdateCity activity = (UpdateCity) getActivity();
                activity.editCity(updatedCity, position);

                dismiss();
            }
        });
    }

    static AddEditDialog newInstance(City city, int position) {
        Bundle args = new Bundle();
        args.putSerializable("city", city);
        args.putInt("position", position);

        AddEditDialog fragment = new AddEditDialog();
        fragment.setArguments(args);
        return fragment;
    }
}
