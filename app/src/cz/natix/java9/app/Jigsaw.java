package cz.natix.java9.app;

import cz.natix.java9.lib.api.TimeService;
//import cz.natix.java9.lib.internal.Formatter;

import java.lang.reflect.*;
import java.time.*;
import java.util.*;

import static cz.natix.java9.app.Actions.runAll;
import static java.lang.System.out;

public class Jigsaw {

    public static void main(String[] args) {
        new Jigsaw().run();
    }

    void run() {
        runAll(Map.of("useModule", this::useModule,
                "reflection", this::reflection));
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
            String s = "hello";

            Method lengthMethod = String.class.getMethod("length");
            int length = (int) lengthMethod.invoke(s);
            out.println(length);

            Field valueField = String.class.getDeclaredField("value");
            valueField.setAccessible(true);
            byte[] value = (byte[]) valueField.get(s);
            out.println(Arrays.toString(value));
        } catch (Exception e) {
            e.printStackTrace(out);
        }
    }
}
