package com.example.calci;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button add;
    Button sub;
    Button mul;
    Button div;
    EditText firstET;
    EditText secondET;
    TextView result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();

    }
    public void initialize(){
        firstET =findViewById(R.id.first_number);
        secondET =findViewById(R.id.second_number);
        result =findViewById(R.id.result);
        add = findViewById(R.id.add);
        sub = findViewById(R.id.sub);
        div = findViewById(R.id.div);
        mul = findViewById(R.id.mul);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {

                    int n1 = Integer.parseInt(firstET.getText().toString());
                    int n2 = Integer.parseInt(secondET.getText().toString());

                    result.setText("Total value = "+ (n1+n2));
                }catch (Exception e) {

                }

            }
        });
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {


                    int n1 = Integer.parseInt(firstET.getText().toString());
                    int n2 = Integer.parseInt(secondET.getText().toString());

                    int n3;
                    n3= subtract(n1,n2);
                    result.setText("Total value = "+ n3);
                }catch (Exception e) {

                }
            }
        });
        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {


                    int n1 = Integer.parseInt(firstET.getText().toString());
                    int n2 = Integer.parseInt(secondET.getText().toString());

                    int n3;
                    n3= multiply(n1,n2);
                    result.setText("Total value = "+ n3);
                }catch (Exception e) {

                }
            }
        });
        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {


                    int n1 = Integer.parseInt(firstET.getText().toString());
                    int n2 = Integer.parseInt(secondET.getText().toString());

                    int n3;
                    n3= division(n1,n2);
                    result.setText("Total value = "+ n3);
                }catch (Exception e) {

                }
            }
        });

    }
    public int addition(int n1,int n2)
    {
        int result = n1+n2;
        return result;
    }

    public int subtract(int n1,int n2)
    {
        int result =n1-n2;
        return result;

    }

    public int multiply(int n1,int n2)
    {
        int result =n1*n2;
        return result;

    }

    public int division(int n1,int n2)
    {
        int result =n1/n2;
        return result;

    }


}