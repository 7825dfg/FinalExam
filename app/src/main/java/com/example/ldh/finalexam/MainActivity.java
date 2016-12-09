package com.example.ldh.finalexam;

import android.graphics.Color;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn1, btn2, btn3, btn4;
    Switch switch1;
    LinearLayout LL1, LL2;
    Chronometer Cmeter;
    RadioGroup radioGroup;
    RadioButton rb1, rb2, rb3;
    ImageView imageView;
    EditText editText1, editText2, editText3;
    TextView tview1, tview2, tview3;
    String num1, num2, num3;
    double result, total;
    int count;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("놀이동산 예약시스템");

        switch1 = (Switch)findViewById(R.id.Switch);
        LL1 = (LinearLayout)findViewById(R.id.LL1);
        LL2 = (LinearLayout)findViewById(R.id.LL2);
        Cmeter = (Chronometer)findViewById(R.id.chronometer);
        radioGroup = (RadioGroup)findViewById(R.id.RadioGroup);
        imageView = (ImageView)findViewById(R.id.imageView);
        editText1 = (EditText)findViewById(R.id.editText1);
        editText2 = (EditText)findViewById(R.id.editText2);
        editText3 = (EditText)findViewById(R.id.editText3);
        btn1 = (Button)findViewById(R.id.button1);
        btn2 = (Button)findViewById(R.id.button2);
        rb1 = (RadioButton)findViewById(R.id.radioButton);
        rb2 = (RadioButton)findViewById(R.id.radioButton2);
        rb3 = (RadioButton)findViewById(R.id.radioButton3);
        tview1 = (TextView)findViewById(R.id.tView5);
        tview2 = (TextView)findViewById(R.id.tView6);
        tview3 = (TextView)findViewById(R.id.tView7);

        LL1.setVisibility(View.INVISIBLE);
        LL2.setVisibility(View.INVISIBLE);

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

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(group.getId()==R.id.RadioGroup){
                    switch (checkedId){
                        case R.id.radioButton :
                            imageView.setImageResource(R.drawable.pic1);
                            break;
                        case R.id.radioButton2 :
                            imageView.setImageResource(R.drawable.pic2);
                            break;
                        case R.id.radioButton3 :
                            imageView.setImageResource(R.drawable.pic3);
                    }
                }
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1 = editText1.getText().toString();
                num2 = editText2.getText().toString();
                num3 = editText3.getText().toString();

                if(num1.isEmpty() || num2.isEmpty() || num3.isEmpty()){
                    Toast.makeText(getApplicationContext(), "인원을 입력하세요", Toast.LENGTH_SHORT).show();
                    return;
                }
                total = (Integer.parseInt(num1)*15000)+(Integer.parseInt(num2)*12000)+ (Integer.parseInt(num3)*8000);
                count = Integer.parseInt(num1)+Integer.parseInt(num2)+Integer.parseInt(num3);

                if(rb1.isChecked()){
                   result = total * 0.95;
                }
                else if(rb2.isChecked()){
                    result = total * 0.9;
                }
                else if (rb3.isChecked()){
                    result = total * 0.8;
                }

                tview1.setText("총 명수 : "+count);
                tview2.setText(String.format("할인금액 : %.0f", result));
                tview3.setText(String.format("결제금액 : %.0f", total));
            }
        });
    }
}
