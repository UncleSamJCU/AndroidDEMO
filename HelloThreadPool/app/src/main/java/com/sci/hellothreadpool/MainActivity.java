package com.sci.hellothreadpool;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btnOnClick(View view) {
        //testCache();
        //testFixed();
        testSingle();
    }


    public void testCache(){
        ExecutorService cacheThreadPool = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {

            final int index = i;

            cacheThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    Log.d("TAG",Thread.currentThread().getName()+".run() --at--" + index);

                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            
        }

    }

    public void testFixed(){
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            final int index = i;
            fixedThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    Log.d("TAG",Thread.currentThread().getName()+".run() --at--" + index);
                }
            });
        }
    }

    public void testSingle(){
        ExecutorService singleThreadPool = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            final int index = i;
            singleThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    Log.d("TAG",Thread.currentThread().getName()+".run() --at--" + index);
                }
            });
        }
    }

    public void testSchedule(){
        
    }


}