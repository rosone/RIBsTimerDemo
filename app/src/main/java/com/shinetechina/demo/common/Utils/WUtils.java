package com.shinetechina.demo.common.Utils;

import java.util.Formatter;
import java.util.Locale;

/**
 * Created by Arthur on 2018/11/10.
 * tools
 */
public class WUtils {

    private static StringBuilder formaterBuilder = new StringBuilder();

    private static Formatter formatter = new Formatter(formaterBuilder,Locale.getDefault());


    /**
     *
     * @param totalSeconds
     * @return
     */
    public static String stringFromTime(long totalSeconds) {

        long seconds = totalSeconds % 60;
        long minutes = (totalSeconds/60)%60;
        formaterBuilder.setLength(0);


      return formatter.format("%02d:%02d",minutes,seconds).toString();

    }

}