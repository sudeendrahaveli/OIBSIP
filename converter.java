package com.example.unitconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView unit_converter;
    EditText value;
    Button pounds;
    TextView result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initializing weights
        pounds = findViewById(R.id.pounds);

        value =  findViewById(R.id.value);

        result =findViewById(R.id.result);


        //Adding  aclick event
        pounds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ConvertFromKiloToPound();

            }
        });


    }

    private void ConvertFromKiloToPound() {
        // Convert kilo to Pound
        String kiloString=value.getText().toString();



        // Convert string to num
        if(!kiloString.trim().isEmpty()) {
            try {
                double kilo = Double.parseDouble(kiloString);
                double Pounds = kilo * 2.205;
                result.setText("" + Pounds);
            }catch (Exception e) {

            }
        }
    }


}
