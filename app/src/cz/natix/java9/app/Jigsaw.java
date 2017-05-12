package cz.natix.java9.app;

import cz.natix.java9.lib.api.TimeService;
import cz.natix.java9.lib.internal.Formatter;

import java.time.*;
import java.util.Locale;

import static java.lang.System.out;

public class Jigsaw {

    public static void main(String[] args) {
        TimeService service = new TimeService();

        Locale locale = new Locale("cs", "CZ");
        ZoneId zone = ZoneId.of("Europe/Prague");

        out.println("Kolik je v Praze hodin?");
        out.println(service.currentTime(zone, locale));
        out.println(Formatter.format(ZonedDateTime.now(), locale));
    }
}
