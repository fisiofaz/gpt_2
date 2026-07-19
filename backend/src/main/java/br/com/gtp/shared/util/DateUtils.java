package br.com.gtp.shared.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public final class DateUtils {

    private DateUtils(){}

    public static final DateTimeFormatter DATE =
            DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static final DateTimeFormatter DATE_TIME =
            DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    public static String format(LocalDate date) {

        if (date == null)
            return null;

        return date.format(DATE);
    }

    public static String format(LocalDateTime dateTime) {

        if (dateTime == null)
            return null;

        return dateTime.format(DATE_TIME);
    }

}