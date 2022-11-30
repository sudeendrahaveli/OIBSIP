package com.example.stopwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private int seconds=0;
    private boolean running=false;
    Button start;
    Button stop;
    Button reset;
    TextView timer;
    Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialize();
    }

    private void initialize() {
        start = findViewById(R.id.start);
        stop = findViewById(R.id.stop);
        reset = findViewById(R.id.reset);
        timer = findViewById(R.id.timer);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onPressStart();
            }
        }); stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onPressStop();
            }
        });
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onPressReset();
            }
        });
    }

    public void onPressStart(){
        if(!running) {
            startTimer();
        }

    }
    public void onPressStop(){
        if(running) {
            running = false;
            handler.removeCallbacks(null);
        }
    }
    public void onPressReset( ) {
        onPressStop();
        seconds= 0;
        onPressStop();

        //startTimer();
    }
    private void startTimer(){
        running = true;
        handler=new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                int hrs = seconds / 3600;
                int mins =(seconds%3600)/60;
                int sec=seconds%60;
                String time=String.format("%02d:%02d:%02d",hrs,mins,sec);
                timer.setText(time);
                if(running){
                    seconds++;
                }
                handler.postDelayed(this,0);
            }


        });
    }

}