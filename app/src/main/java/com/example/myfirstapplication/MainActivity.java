package com.example.myfirstapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    private final double MILE_TO_KM = 1.609344;
    private final double KM_TO_MILE = 0.621371;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText textBoxMiles = findViewById(R.id.editTextTextMiles);
        EditText textBoxKm = findViewById(R.id.editTextTextKilometers);
        Button buttonConvMilesToKm = findViewById(R.id.buttonConvMilesToKilometers);
        Button buttonConvKmtoMiles = findViewById(R.id.buttonConvKilometerToMiles);
        DecimalFormat formatVal = new DecimalFormat("##.##");

        // set an onclick parameter.
        Context context = getApplicationContext();
        buttonConvMilesToKm.setOnClickListener(new ConvertListener(context, textBoxKm, textBoxMiles, MILE_TO_KM, formatVal));
        buttonConvKmtoMiles.setOnClickListener(new ConvertListener(context, textBoxMiles, textBoxKm, KM_TO_MILE, formatVal));
    }
}