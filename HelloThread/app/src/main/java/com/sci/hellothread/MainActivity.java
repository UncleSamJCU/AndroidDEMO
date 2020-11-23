package com.sci.hellothread;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btnOnClick(View view) {
        //testThread();
       // testRunnable();
        testSale();
    }

    public void testThread(){
        MyThread mt1 = new MyThread();
        MyThread mt2 = new MyThread();
        mt1.start();
        mt2.start();
    }

    public void testRunnable(){
        MyRunnable mr1 = new MyRunnable();
        new Thread(mr1).start();
        new Thread(mr1).start();
     //线程同步的问题必须要注意,参考TestSale
    }

    public void testSale(){
        SaleTicket st1  = new SaleTicket();
        new Thread(st1,"A代理").start();
        new Thread(st1,"B代理").start();
        new Thread(st1,"C代理").start();
        new Thread(st1,"D代理").start();

    }

}