package com.iamtrk.Logger;


import com.iamtrk.Appender.Appender;
import com.iamtrk.Utilities.Level;
import com.iamtrk.Writer.Writer;

import java.util.List;

/**
 * Created by cleartax on 24/01/17.
 */
public class Logger {
    private List<Appender> appenders;
    private Level currentLevel = Level.DEBUG;

    public Logger(List<Appender> appenders, Level level) {
        this.appenders = appenders;
        this.currentLevel = level;
    }

    public boolean write(Level level, String text) {

        switch (level) {
            case TRACE:
                Writer.write(level, text, appenders);
                break;
            case DEBUG:
                if(level.equals(Level.DEBUG) || level.equals(Level.SEVERE)) {
                    Writer.write(level, text, appenders);
                }
                break;
            case SEVERE:
                if(level.equals(Level.SEVERE)) {
                    Writer.write(level, text, appenders);
                }
                break;
        }


        return true;
    }


}
