package com.sci.hellothread;

import android.util.Log;

public class SaleTicket implements Runnable {

    private int tickNumber = 20;

    @Override
    public void run() {
        while (true){

            synchronized (this){
                if (tickNumber>0){
                    Log.d("TAG", Thread.currentThread().getName()+"Ticket Left:"+tickNumber);
                    tickNumber--;

                }else //火车票卖完了
                {
                    break;
                }
            }

            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
