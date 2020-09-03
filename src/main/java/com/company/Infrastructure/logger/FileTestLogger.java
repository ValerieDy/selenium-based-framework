package com.company.Infrastructure.logger;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileTestLogger implements TestLogger {

    private String filePath = "./src/Infrastructure/logger/log.txt";
    private List<String> logLists = new ArrayList<>();

    @Override
    public void writeLog(String msg) {

        //add message to logList
        logLists.add(msg);

    }

    public void saveToFile(){

        File file = new File(filePath);
        FileWriter fr = null;

        try {
            fr = new FileWriter(file, true);
            for (String msg: logLists) {

                fr.write(msg);
                fr.write(System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

//    public static void main(String[] args) {
//        FileTestLogger testLogger = new FileTestLogger();
//        testLogger.log("testStr1");
//        testLogger.saveToFile();
//
//    }

}

