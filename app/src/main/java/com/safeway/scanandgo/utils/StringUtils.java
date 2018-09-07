package com.safeway.scanandgo.utils;

public final class StringUtils {

    private StringUtils() {

    }

    public static boolean isEmpty(final String string) {
        return string == null || string.isEmpty();
    }

    public static int length(final String string) {
        return isEmpty(string) ? 0 : string.length();
    }
}
