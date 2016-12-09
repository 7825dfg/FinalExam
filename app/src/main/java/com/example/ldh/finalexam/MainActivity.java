package com.example.ldh.finalexam;

import android.graphics.Color;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {

    Button btn1, btn2, btn3, btn4;
    Switch switch1;
    LinearLayout LL1;
    Chronometer Cmeter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("놀이동산 예약시스템");

        switch1 = (Switch)findViewById(R.id.Switch);
        LL1 = (LinearLayout)findViewById(R.id.LL1);
        Cmeter = (Chronometer)findViewById(R.id.chronometer);
        LL1.setVisibility(View.INVISIBLE);

        switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked==true){
                    Cmeter.setBase(SystemClock.elapsedRealtime());
                    Cmeter.start();
                    Cmeter.setTextColor(Color.BLUE);
                    LL1.setVisibility(View.VISIBLE);
                }
                else{
                    Cmeter.setBase(SystemClock.elapsedRealtime());
                    Cmeter.stop();
                    Cmeter.setTextColor(Color.BLACK);
                    LL1.setVisibility(View.INVISIBLE);
                }
            }
        });
    }
}
