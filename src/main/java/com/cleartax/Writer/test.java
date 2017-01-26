package com.cleartax.Writer;


import com.cleartax.Appender.Appender;
import com.cleartax.Appender.AppenderImpl.FileAppender;
import com.cleartax.Logger.Logger;
import com.cleartax.Utilities.Level;

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
