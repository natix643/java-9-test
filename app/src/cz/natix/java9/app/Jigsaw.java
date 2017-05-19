package cz.natix.java9.app;

import cz.natix.java9.lib.api.TimeService;
//import cz.natix.java9.lib.internal.Formatter;

import java.lang.reflect.Field;
import java.time.*;
import java.util.*;

import static cz.natix.java9.app.Actions.runAll;
import static java.lang.System.out;

public class Jigsaw {

    public static void main(String[] args) {
        new Jigsaw().run();
    }

    void run() {
        runAll(List.of(this::useModule, this::reflection));
    }

    void useModule() {
        TimeService service = new TimeService();

        Locale locale = new Locale("cs", "CZ");
        ZoneId zone = ZoneId.of("Europe/Prague");

        out.println("Kolik je v Praze hodin?");
        out.println(service.currentTime(zone, locale));
//        out.println(Formatter.format(ZonedDateTime.now(), locale));
    }

    void reflection() {
        try {
            Field field = String.class.getDeclaredField("value");
            field.setAccessible(true);

            byte[] value = (byte[]) field.get("hello");
            out.println(Arrays.toString(value));
        } catch (Exception e) {
            e.printStackTrace(out);
        }
    }
}
