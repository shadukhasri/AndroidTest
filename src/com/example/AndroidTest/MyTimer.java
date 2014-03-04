package com.example.AndroidTest;

import java.io.InterruptedIOException;

/**
 * Created by Tmi on 2/25/14.
 */
public class MyTimer extends Thread {

    private int time;
    private MyActivity main;


    public MyTimer(MyActivity main,int threshold) {
        this.main=main;
        time = threshold;
    }

    public void run() {
        for (int i=1; i<=time; i++) {
            final int v = i;
            try {
                Thread.sleep(1000);
//                main.setCurrentTime(time-i);
                main.timerHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        main.setCurrentTime(time - v);
                    }
                });
            } catch(InterruptedException e) {
                System.out.println("Exception");
            }
        }
        main.timeOff();
        main.timerHandler.post(new Runnable() {
            @Override
            public void run() {
                main.showFinalScore();
            }
        });
    }
}
