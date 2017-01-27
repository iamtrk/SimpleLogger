package com.iamtrk.Writer;


import com.iamtrk.Appender.Appender;
import com.iamtrk.Appender.AppenderImpl.FileAppender;
import com.iamtrk.Logger.Logger;
import com.iamtrk.Utilities.Level;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cleartax on 24/01/17.
 */
public class test {
    static List<Appender> appenders;
    static Logger logger;

    public static void main(String[] args) {
        appenders = new ArrayList<>();
        appenders.add(new FileAppender("/Users/cleartax/logs/logger.txt", 2, 50));


        logger = new Logger(appenders, Level.DEBUG);
        logger.write(Level.DEBUG, "DEBUG");
        logger.write(Level.SEVERE, "SEVERE");
        logger.write(Level.TRACE, "TRACE");

    }
}
