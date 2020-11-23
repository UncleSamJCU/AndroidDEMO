package com.sci.threadtest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView textView;
    public static final int UPDAT_TEXT = 1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.text);
        Button changeText = findViewById(R.id.btn_changeText);

//        changeText.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                switch (v.getId()){
//                    case R.id.btn_changeText:
//                        new Thread(new Runnable() {
//                            @Override
//                            public void run() {
//                                textView.setText("Nice to meet you!!");
//                            }
//                        }).start();
//                        break;
//                    default:
//                        break;
//                }
//            }
//        });


    }

    @Override
    public void onClick(View v) {

        private Handler handler = new Handler(){

        }

    }
}