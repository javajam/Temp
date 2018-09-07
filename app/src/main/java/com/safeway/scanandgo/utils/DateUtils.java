package com.safeway.scanandgo.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public final class DateUtils {

    private static final String TIME_STAMP_PATTERN = "MMM d, yyyy, HH:mm a";

    private DateUtils() {

    }

    public static String getStandardDate() {
        return formatDate(new Date(), TIME_STAMP_PATTERN);
    }

    public static String formatDate(Date date, String outputFormat) {
        return createSimpleDateFormat(outputFormat).format(date);
    }

    public static SimpleDateFormat createSimpleDateFormat(String format) {
        return new SimpleDateFormat(format, Locale.US);
    }
}
