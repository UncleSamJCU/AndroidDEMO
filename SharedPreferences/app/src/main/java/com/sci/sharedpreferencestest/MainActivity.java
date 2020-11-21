package com.sci.sharedpreferencestest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button mBtnSaveData;
    private Button mBtnReadData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBtnSaveData = findViewById(R.id.btn_saveData);
        mBtnReadData = findViewById(R.id.btn_readData);

        mBtnSaveData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = getSharedPreferences("data",MODE_PRIVATE).edit();
                editor.putString("name","UncleSam");
                editor.putInt("age",18);
                editor.putBoolean("married",true);
                editor.apply();
                //data/data/<package-name>/shared_prefs/上面的name的文件名称
               Toast.makeText(MainActivity.this,"The data is saved!",Toast.LENGTH_SHORT).show();
                Log.d("Mainactivity","the data is saved, congrats");
            }
        });

        mBtnReadData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences pref = getSharedPreferences("data",MODE_PRIVATE);
                String name = pref.getString("name","");
                //如果没有找到，则用后面的defValue来替代
                int age = pref.getInt("age",0);
                boolean married = pref.getBoolean("married",false);
                Log.d("MainActivity","name is "+name);
                Log.d("MainActivity","age is "+age);
                Log.d("MainActivity","Marry status is "+married);

                String info = "name is:" + name +"Age is :"+age+"Marry status is :"+married;

                Toast.makeText(MainActivity.this,info,Toast.LENGTH_SHORT).show();



            }
        });


    }


}