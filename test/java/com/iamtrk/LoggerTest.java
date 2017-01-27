package com.iamtrk;



import com.iamtrk.Appender.Appender;
import com.iamtrk.Appender.AppenderImpl.FileAppender;
import com.iamtrk.Logger.Logger;
import com.iamtrk.Utilities.Level;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by cleartax on 24/01/17.
 */
public class LoggerTest {

    List<Appender> appenders;
    Logger logger;
    String dir = "/Users/m01231/wrk/testRotlogs";
    String path = dir+"/log.txt";

    @Test
    public void testPrintMessage() {

        appenders = new ArrayList<>();
        appenders.add(new FileAppender(path, 2, 50));
        logger = new Logger(appenders, Level.DEBUG);

        File directory = new File(dir);
        File[] files = directory.listFiles();
        for (File file : files)
        {
            if (!file.delete())
            {
                System.out.println("Failed to delete "+file);
            }
        }
        logger.write(Level.DEBUG, "DEBUG");
        logger.write(Level.SEVERE, "SEVERE");
        logger.write(Level.TRACE, "TRACE");
        String logLine ;

        try {
            BufferedReader reader = new BufferedReader(new FileReader(path+"1"));

            while ((logLine = reader.readLine())!=null) {
                assert logLine.contains("localhost::: TRACE:::TRACE");
            }

            reader = new BufferedReader(new FileReader(path+"2"));

            while ((logLine = reader.readLine())!=null) {
                assert logLine.contains("localhost::: SEVERE:::SEVERE");
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
