package cz.natix.java9.lib.api;

import cz.natix.java9.lib.internal.Formatter;

import java.time.*;
import java.util.Locale;

public class TimeService {

    public String currentTime(ZoneId zone, Locale locale) {
        ZonedDateTime now = ZonedDateTime.now(zone);
        return Formatter.format(now, locale);
    }
}
