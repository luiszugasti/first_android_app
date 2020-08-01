package com.example.myfirstapplication;

import android.content.Context;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.text.DecimalFormat;

public class ConvertListener implements View.OnClickListener {

    final EditText from;
    final EditText to;
    final double convFactor;
    final DecimalFormat formatVal;

    // not sure this is the recommended way of doing this, as context may change in different activities
    final Context context;

    public ConvertListener(Context context, EditText from, EditText to, double convFactor, DecimalFormat formatVal) {
        this.from = from;
        this.to = to;
        this.convFactor = convFactor;
        this.formatVal = formatVal;
        this.context = context;
    }

    @Override
    public void onClick(View v) {
        double valFrom = 0;
        try {
            valFrom = Double.parseDouble(from.getText().toString());
        } catch (NumberFormatException e) {
            CharSequence text = "Invalid value, try again!";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }

        double valTo = valFrom * convFactor;
        to.setText(formatVal.format(valTo));
    }
}
