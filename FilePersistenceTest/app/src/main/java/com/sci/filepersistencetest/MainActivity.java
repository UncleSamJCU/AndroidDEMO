package com.sci.filepersistencetest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    private EditText mEditText;
    private Button mBtnSaveFile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        mEditText = findViewById(R.id.edit);
        mBtnSaveFile = findViewById(R.id.btn_saveFile);

        mBtnSaveFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Log.d("Mainactivity","---file save------------");
                String inputText = mEditText.getText().toString();
                Log.d("---inputtext---",inputText);
                //saveFile(inputText);
                //TODO: 2020年11月21日20:18:31

                Toast.makeText(MainActivity.this,"File saved!",Toast.LENGTH_SHORT).show();
            }
        });


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //here could add some logic for the VIEW
    }

    public void saveFile(String inputText){
        FileOutputStream out = null;
        BufferedWriter writer = null;

        try {
            out = openFileOutput("data", Context.MODE_PRIVATE);
            writer = new BufferedWriter(new OutputStreamWriter(out));
            writer.write(inputText);

        } catch (IOException e) {
            e.printStackTrace();
        }finally{
                try {
                    if (writer!=null){
                        writer.close();
                    }

                }catch (IOException e){
                    e.printStackTrace();
                }
        }

    }
}