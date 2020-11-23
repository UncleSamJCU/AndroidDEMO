package com.sci.litepaltest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.sci.litepaltest.models.Album;

import org.litepal.LitePal;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button mBtnCreate;
    private Button mBtnAddData;
    private Button mBtnUpdateData;
    private Button mBtnDelData;
    private Button mBtnQueryData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBtnCreate = findViewById(R.id.btn_createDB);
        mBtnAddData = findViewById(R.id.btn_addData);
        mBtnDelData = findViewById(R.id.btn_deleteData);
        mBtnUpdateData = findViewById(R.id.btn_updateData);
        mBtnQueryData = findViewById(R.id.btn_queryData);

        mBtnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LitePal.getDatabase();
                Log.d("--MainActivity--","Db created");
            }
        });

        mBtnAddData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Album album = new Album();
                album.setName("Da Vinci");
                album.setPrice(38476.08F);

                album.save();
                album.setName("Li Ning");
                album.setPrice(500.55f);
                album.save();
                Log.d("--MainActivity--","data added");
                
            }
        });

        //Update DATA TODO 2020年11月21日22:32:27
//
//        Album albumToUpdate = LitePal.find(Album.class, 1);
//        albumToUpdate.setPrice(20.99f); // raise the price
//        albumToUpdate.save();
        //https://github.com/guolindev/LitePal.git


        mBtnQueryData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Find all data
                List<Album> albums = LitePal.findAll(Album.class);
                for (Album album :albums
                     ) {
                    Log.d("===Name is:= ",album.getName());
                    Log.d("==Price is:="," " + album.getPrice());
                }
                //Find Single
               // Song song = LitePal.find(Song.class, id);

            }
        });



    }
}