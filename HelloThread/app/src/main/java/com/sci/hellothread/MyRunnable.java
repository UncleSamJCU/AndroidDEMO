package com.sci.hellothread;

import android.util.Log;

public class MyRunnable implements Runnable {

    @Override
    public void run() {
        Log.d("RUNNABLE",Thread.currentThread().getName()+".is running...");
    }
}
