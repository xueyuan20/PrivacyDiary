package com.syalife.diary.test.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Administrator on 2016/3/16.
 *
 */
public class TimeUtils {
    protected String[] FORMATS = new String[]{
            "yyyy-MM-dd",
            "HH:mm",
            "yyyy-MM-dd HH:mm"
    };

    private static TimeUtils instance;

    private TimeUtils() {
    }

    public static TimeUtils getInstance() {
        if (instance == null) {
            instance = new TimeUtils();
        }
        return instance;
    }

    public String getCurrentDate() {
        SimpleDateFormat sdf = new SimpleDateFormat(FORMATS[0], Locale.US);
        /**
         * Set TimeZone:
         *            sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
         */

        return sdf.format(new Date());
    }

    public String getCurrentTime() {
        SimpleDateFormat sdf = new SimpleDateFormat(FORMATS[1], Locale.US);
        /**
         * Set TimeZone:
         *            sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
         */

        return sdf.format(new Date());
    }

    public String getCurrentDateAndTime() {
        SimpleDateFormat sdf = new SimpleDateFormat(FORMATS[2], Locale.US);
        /**
         * Set TimeZone:
         *            sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
         */
        return sdf.format(new Date());
    }
}
