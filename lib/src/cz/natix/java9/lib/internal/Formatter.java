package cz.natix.java9.lib.internal;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import static java.time.format.FormatStyle.FULL;

public class Formatter {

    public static String format(ZonedDateTime dateTime, Locale locale) {
        DateTimeFormatter f = DateTimeFormatter.ofLocalizedDateTime(FULL).withLocale(locale);
        return f.format(dateTime);
    }
}
