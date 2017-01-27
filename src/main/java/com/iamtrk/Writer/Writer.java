package com.iamtrk.Writer;



import com.iamtrk.Appender.Appender;
import com.iamtrk.Utilities.Level;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Date;
import java.util.List;

/**
 * Created by cleartax on 24/01/17.
 */
public class Writer {


    public static synchronized void write(Level level, String text, List<Appender> appenders) {
        try {
            for (Appender appender : appenders) {
                // Opening & Closing the buffer for each write, Doesn't look optimized.
                BufferedWriter writer = new BufferedWriter(new FileWriter(appender.getPath(), true));
                // Hard coding the host as InetAddress.getLocalHost().getHostName() is slow. Hint: Cache.
                writer.write(new Date() + "::: localhost::: " + level + ":::" + text);
                writer.newLine();
                writer.flush();
                writer.close();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
