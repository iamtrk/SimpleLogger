package com.cleartax.Appender.AppenderImpl;


import com.cleartax.Appender.Appender;
import com.cleartax.Utilities.Utils;

/**
 * Created by cleartax on 24/01/17.
 */
public class FileAppender implements Appender {
    private boolean rotation_enabled;
    private int NUM_FILES;
    private int current_file = 1;
    private String path;
    private int FILE_SIZE;

    public FileAppender(String path) {
        this.path = path;
    }

    public FileAppender(String path, int NUM_FILES, int FILE_SIZE) {
        this.path = path;
        this.NUM_FILES = NUM_FILES;
        this.FILE_SIZE = FILE_SIZE;
        this.rotation_enabled = true;
    }

    public String getPath() {

        if(rotation_enabled) {
            if(Utils.getFileSize(path + current_file) < FILE_SIZE) {
                return path+current_file;
            }

            if(current_file == NUM_FILES) {
                current_file = 1;
            } else {
                current_file ++;
            }

            Utils.truncate(path+current_file);

            return path+current_file;

        }

        return path;

    }
}
