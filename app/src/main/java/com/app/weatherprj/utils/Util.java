package com.app.weatherprj.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Util {
    public static String dateFromTimeStamp(long timestamp) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-mm-yyyy HH:mm:ss", Locale.getDefault());

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis((int) timestamp);
        return formatter.format(calendar.getTime());
    }
}
