package br.com.gtp.shared.util;

import java.text.Normalizer;

public final class StringUtils {

    private StringUtils() {
    }

    public static boolean isNullOrBlank(String value) {
        return value == null || value.isBlank();
    }

    public static boolean hasText(String value) {
        return !isNullOrBlank(value);
    }

    public static String capitalize(String value) {

        if (isNullOrBlank(value)) {
            return value;
        }

        return value.substring(0, 1).toUpperCase()
                + value.substring(1).toLowerCase();
    }

    public static String onlyNumbers(String value) {

        if (value == null) {
            return null;
        }

        return value.replaceAll("\\D", "");
    }

    public static String removeAccents(String value) {

        if (value == null) {
            return null;
        }

        return Normalizer.normalize(value, Normalizer.Form.NFD)
                .replaceAll("\\p{M}", "");
    }

    public static String normalize(String value) {

        if (value == null) {
            return null;
        }

        return removeAccents(value)
                .trim()
                .toUpperCase();
    }

}