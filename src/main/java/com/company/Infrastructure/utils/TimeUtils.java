package com.company.Infrastructure.utils;

public class TimeUtils {
    public static void waitFor () {
        try {
            Thread.sleep(1000);
        }catch (Exception ex){

        }

    }

    public static void waitFor (int miliseconds) {
        try {
            Thread.sleep(miliseconds);
        }catch (Exception ex){

        }

    }
}
