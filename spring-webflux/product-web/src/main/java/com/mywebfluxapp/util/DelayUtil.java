package com.mywebfluxapp.util;

public class DelayUtil {

    public static void delay(int seconds){
        try {
            Thread.sleep(seconds*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
