package com.safeway.scanandgo.utils;

import java.util.Collection;

public final class CollectionUtils {

    private CollectionUtils() {

    }

    public static boolean isEmpty(final Collection<?> collection) {
        return collection == null || collection.isEmpty();
    }

    public static int size(final Collection<?> collection) {
        return isEmpty(collection) ? 0 : collection.size();
    }
}
