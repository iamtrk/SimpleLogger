package com.cleartax.Utilities;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;

/**
 * Created by cleartax on 24/01/17.
 */
public class Utils {
    public static int getFileSize(String path) {
        return (int) new File(path).length();
    }

    public static boolean truncate(String path) {
        boolean res = true;
        try {
            FileChannel outChan = new FileOutputStream(path, true).getChannel();
            outChan.truncate(0);
            outChan.close();;
        } catch (Exception ex) {
            ex.printStackTrace();
            res = false;
        }

        return res;
    }
}
