package com.company.Infrastructure.logger;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CmdTestLogger implements TestLogger {

    private int step = 1;

    @Override
    public void writeLog(String msg){
        System.out.println( step + ")" + timesStamp() + "[" + methodName() + "]" + msg);
        step++;
    }

    private String timesStamp(){
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss.SSS");
        return  sdf.format(new Date());
    }


    private String methodName(){
            return Thread.currentThread().getName();
    }

}







